package app_58_threads_pool;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.*;

public class Threads_Pool {
    // создается сразу пулл потоков (ничем не отличется от обычного потока),
    // и ему вскармливаются задачи для того
    // чтобы они выполнялись по мере освобождения потока

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool1 =Executors.newSingleThreadExecutor(); // пулл из одного потока
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5); // пулл с указанием колличества
        Executors.newCachedThreadPool(); // пулл безграничный - столько потоков сколько их таксов отправлено (но не будет их увеличивать если ипотоков хватает)
        ScheduledExecutorService threadPool3 =  Executors.newScheduledThreadPool(3); // по расписанию запуск
        ScheduledExecutorService threadPool4 =  Executors.newScheduledThreadPool(3); // по расписанию запуск
        Executors.newWorkStealingPool(); // сосзадет пулл на основании доступных колличство процессоров Runtime.getRuntime().availableProcessors;

        Future<Integer> future = threadPool1.submit(() -> { return 1;} );
        System.out.println(future.get()); // блочит поток вызвавщие его

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> { return 2;}); // аналог future, но не нужен поток, т.к. использует деволтный (хотя его и можно передать в параметр)
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> { return 3;}, threadPool2);
        System.out.println(completableFuture.get());
        System.out.println(completableFuture2.get());



        threadPool3.schedule(() -> System.out.println("4"), 3, TimeUnit.SECONDS); // запуск с задержкой
        threadPool4.scheduleAtFixedRate(() -> System.out.println("5"), 1, 1, TimeUnit.SECONDS); // запуск c задержкой и периодичностью

        threadPool1.shutdown();
        threadPool1.awaitTermination(10, TimeUnit.SECONDS);
        threadPool2.shutdown();
        threadPool2.awaitTermination(10, TimeUnit.SECONDS);
        threadPool3.shutdown();
        threadPool3.awaitTermination(10, TimeUnit.SECONDS);
        threadPool4.shutdown();
        threadPool4.awaitTermination(10, TimeUnit.SECONDS);


        // Пример использования кастомного ThreadPool
        Queue<Runnable> queue = new ArrayDeque<Runnable>();
        queue.add(() -> System.out.println("Task 1"));
        CustomThreadPool pool = new CustomThreadPool(queue);
        pool.start();
        pool.join();
    }

}

class CustomThreadPool extends Thread {
    private final Queue<Runnable> tasks;

    public CustomThreadPool(Queue<Runnable> tasks){
        this.tasks  = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                if(!tasks.isEmpty()){
                    task = Optional.of(tasks.poll());
                }
            }
            task.ifPresent((Runnable r) -> r.run());
            break; // чтобы прервать цикл, а так в целом можно бесконечно добавлять tasks
        }
    }
}
