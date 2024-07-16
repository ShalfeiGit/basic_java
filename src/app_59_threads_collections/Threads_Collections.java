package app_59_threads_collections;

import java.util.Comparator;
import java.util.stream.Stream;
import java.util.concurrent.*;

public class Threads_Collections {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayBlockingQueue<Integer> blockingDeque =  new ArrayBlockingQueue<>(16);
        ConcurrentHashMap<String, Integer> concurrentMap =  new ConcurrentHashMap<>();
        Comparator<Integer> comparator = Integer::compare;
        Comparator<String> comparator_2 = new StringComparator();
        ConcurrentSkipListMap<String, Integer> concurrentNavigableMap =  new ConcurrentSkipListMap<>(comparator_2); // аналог treemap в коллекциях
        ConcurrentSkipListSet<Integer> concurrentSkipListSet =  new ConcurrentSkipListSet<>(comparator);

        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        Future<?> task = threadPool1.submit(() -> {
            Stream.of(1, 2, 3, 4).forEach(el -> {
                blockingDeque.add(el);
                concurrentMap.put(String.valueOf(el), el);
                concurrentNavigableMap.put(String.valueOf(el), el);
                concurrentSkipListSet.add(el);
            });
        });
        Future<?> task_2 = threadPool1.submit(() -> {
            Stream.of(4, 5, 6, 7).forEach(el -> {
                blockingDeque.add(el);
                concurrentMap.put(String.valueOf(el), el);
                concurrentNavigableMap.put(String.valueOf(el), el);
                concurrentSkipListSet.add(el);
            });
        });
        Future<?> task_3 = threadPool1.submit(() -> {
            Stream.of(8, 9, 10, 11).forEach(el -> {
                blockingDeque.add(el);
                concurrentMap.put(String.valueOf(el), el);
                concurrentNavigableMap.put(String.valueOf(el), el);
                concurrentSkipListSet.add(el);
            });
        });

        task.get();
        task_2.get();
        task_3.get();
        System.out.println("BlockingDeque: " + blockingDeque);
        System.out.println("ConcurrentMap: " + concurrentMap);
        System.out.println("ConcurrentNavigableMap: " + concurrentNavigableMap);
        System.out.println("ConcurrentSkipListSet: " + concurrentSkipListSet);
        threadPool1.shutdown();
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return 1;
        } else if(o1.length() < o2.length()){
            return -1;
        } else if(o1.length() == o2.length()) {
            return o1.compareTo(o2);
        }
        return 0;
    }

}
