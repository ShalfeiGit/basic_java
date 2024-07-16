package app_60_threads_latches;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Threads_Latches {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<File> filesCountDownLatch = Arrays.asList(Path.of("src","app_60_threads_latches", "files").toFile().listFiles());
        ArrayBlockingQueue<File> blockingFileDequeCountDownLatch = new ArrayBlockingQueue<>(filesCountDownLatch.size(), false, filesCountDownLatch);

        List<File> filesCyclicBarrier = Arrays.asList(Path.of("src","app_60_threads_latches", "files").toFile().listFiles());
        ArrayBlockingQueue<File> blockingFileDequeCyclicBarrier = new ArrayBlockingQueue<>(filesCyclicBarrier.size(), false, filesCyclicBarrier);

        List<File> filesSemaphore = Arrays.asList(Path.of("src","app_60_threads_latches", "files").toFile().listFiles());
        ArrayBlockingQueue<File> blockingFileDequeSemaphore = new ArrayBlockingQueue<>(filesSemaphore.size(), false, filesSemaphore);

        CountDownLatch countDownLatch = new CountDownLatch(blockingFileDequeCountDownLatch.size()); // блочит все потоки с вызванным countDownLatch.await(); пока не будет вызвано указанное колличество при инициации countDownLatch.countDown();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(blockingFileDequeCyclicBarrier.size()); // блочит все потоки с вызванным  cyclicBarrier.await(); пока не будет вызвано указанное колличество при инициации countDownLatch.await();
        Semaphore semaphore = new Semaphore(blockingFileDequeSemaphore.size()); // блочит дальнейшее выполенение потока, если коллчество обращений к семафору превысило инициализируемое значение (блокирование колличество semaphore.acquire(); - разблокирование semaphore.release();)

        ExecutorService threadPoolCountDownLatch = Executors.newFixedThreadPool(2);
        threadPoolCountDownLatch.submit(() ->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CountDownLatch: все файлы считаны");
        });
        while(!blockingFileDequeCountDownLatch.isEmpty()){
            threadPoolCountDownLatch.submit(new ReaderFileCountDownLatch(countDownLatch, blockingFileDequeCountDownLatch));
        }

        ExecutorService threadPoolCyclicBarrier = Executors.newCachedThreadPool();
        threadPoolCyclicBarrier.submit(() ->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CyclicBarrier: все файлы считаны");
        });
        blockingFileDequeCyclicBarrier.stream().map(file -> new ReaderFileCyclicBarrier(cyclicBarrier, file)).forEach(runnable -> { threadPoolCyclicBarrier.submit(runnable); });

        ExecutorService threadPoolSemaphore = Executors.newFixedThreadPool(2);
        threadPoolSemaphore.submit(() ->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Semaphore: все файлы считаны");
            semaphore.release();
        });
        blockingFileDequeSemaphore.stream().map(file -> new ReaderFileSemaphore(semaphore, file)).forEach(runnable -> { threadPoolSemaphore.submit(runnable); });

        threadPoolCountDownLatch.shutdown();
        threadPoolCountDownLatch.awaitTermination(10, TimeUnit.SECONDS);

        threadPoolCyclicBarrier.shutdown();
        threadPoolCyclicBarrier.awaitTermination(10, TimeUnit.SECONDS);

        threadPoolSemaphore.shutdown();
        threadPoolSemaphore.awaitTermination(10, TimeUnit.SECONDS);
    }
}

class ReaderFileCountDownLatch implements Callable {
    ArrayBlockingQueue<File> list;
    private final CountDownLatch countDownLatch;

    ReaderFileCountDownLatch(CountDownLatch countDownLatch, ArrayBlockingQueue<File> list) {
        this.countDownLatch = countDownLatch;
        this.list = list;
    }

    @Override
    public String call() throws Exception {
        File file = list.poll();
        if(file.exists()){
            System.out.println("CountDownLatch: Начало считывания значения файла " + file.getName() +" потоком: " + Thread.currentThread().getName());
            String fileValue = Files.readAllLines(file.toPath()).stream().reduce("", (acc, string) -> acc + string);
            System.out.println("CountDownLatch: Значения файла " + fileValue);
            countDownLatch.countDown();
            return fileValue;
        }
        return null;
    }
}

class ReaderFileCyclicBarrier implements Runnable {
    File file;
    private final CyclicBarrier cyclicBarrier;


    ReaderFileCyclicBarrier(CyclicBarrier cyclicBarrier, File file) {
        this.cyclicBarrier = cyclicBarrier;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("CyclicBarrier: Начало считывания значения файла " + file.getName() +" потоком: " + Thread.currentThread().getName());
        String fileValue = null;
        try {
            fileValue = Files.readAllLines(file.toPath()).stream().reduce("", (acc, string) -> acc + string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("CyclicBarrier: Значения файла " + fileValue);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

class ReaderFileSemaphore implements Runnable {
    File file;
    private final Semaphore semaphore;


    ReaderFileSemaphore(Semaphore semaphore, File file) {
        this.semaphore = semaphore;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Semaphore: Начало считывания значения файла " + file.getName() +" потоком: " + Thread.currentThread().getName());
        String fileValue = null;
        try {
            fileValue = Files.readAllLines(file.toPath()).stream().reduce("", (acc, string) -> acc + string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Semaphore: Значения файла " + fileValue);
       semaphore.release();
    }
}
