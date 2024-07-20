package app_54_threads_sharing_inputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Threads_Sharing_Inputs {
    private static volatile boolean check = false; // volatile синхранизация примитивных типов в heap
    public static void main(String[] args) {
        Counter counter = new Counter();
        SynchronizeCounter sync_counter = new SynchronizeCounter();
        List<Integer> list = new ArrayList<>();
        SynchronizeList sync_list1 = new SynchronizeList(new ArrayList<>());
        List<Integer> sync_list2 = Collections.synchronizedList(new ArrayList<>());
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>(); // можно шарить между потоками, запоминают set значение для каждого отдельного потока
        threadLocal.set(10);
        System.out.println(threadLocal.get());


        Thread thread_1 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> counter.incrementCounter()); });
        Thread thread_2 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> counter.incrementCounter()); });
        Thread thread_3 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> counter.incrementCounter()); });
        Thread thread_4 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> counter.incrementCounter()); });

        Thread sync_thread_1 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_counter.incrementCounter()); });
        Thread sync_thread_2 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_counter.incrementCounter()); });
        Thread sync_thread_3 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_counter.incrementCounter()); });
        Thread sync_thread_4 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_counter.incrementCounter()); });

        Thread list_thread_1 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> list.add(list.size() + 1)); });
        Thread list_thread_2 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> list.add(list.size() + 1)); });
        Thread list_thread_3 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> list.add(list.size() + 1)); });
        Thread list_thread_4 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> list.add(list.size() + 1)); });

        Thread sync_list1_thread_1 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list1.incrementList());});
        Thread sync_list1_thread_2 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list1.incrementList());});
        Thread sync_list1_thread_3 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list1.incrementList());});
        Thread sync_list1_thread_4 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list1.incrementList());});

        Thread sync_list2_thread_1 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list2.add(list.size() + 1)); });
        Thread sync_list2_thread_2 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list2.add(list.size() + 1)); });
        Thread sync_list2_thread_3 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list2.add(list.size() + 1)); });
        Thread sync_list2_thread_4 = new Thread(() -> { new ArrayList<Integer>(Arrays.asList(new Integer[1000])).stream().forEach(i -> sync_list2.add(list.size() + 1)); });

        Thread primitive_thread1 = new Thread(() -> { while(!check) System.out.println("check = false"); });
        Thread primitive_thread2 = new Thread(() -> { check = true; System.out.println("check = true"); });

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();

        sync_thread_1.start();
        sync_thread_2.start();
        sync_thread_3.start();
        sync_thread_4.start();

        list_thread_1.start();
        list_thread_2.start();
        list_thread_3.start();
        list_thread_4.start();

        sync_list1_thread_1.start();
        sync_list1_thread_2.start();
        sync_list1_thread_3.start();
        sync_list1_thread_4.start();

        sync_list2_thread_1.start();
        sync_list2_thread_2.start();
        sync_list2_thread_3.start();
        sync_list2_thread_4.start();

        try {

            thread_1.join();
            thread_2.join();
            thread_3.join();
            thread_4.join();

            sync_thread_1.join();
            sync_thread_2.join();
            sync_thread_3.join();
            sync_thread_4.join();

            list_thread_1.join();
            list_thread_2.join();
            list_thread_3.join();
            list_thread_4.join();

            sync_list1_thread_1.join();
            sync_list1_thread_2.join();
            sync_list1_thread_3.join();
            sync_list1_thread_4.join();

            sync_list2_thread_1.join();
            sync_list2_thread_2.join();
            sync_list2_thread_3.join();
            sync_list2_thread_4.join();

            primitive_thread1.start();;
            Thread.sleep(0L); // приостановить выполение текущего потока (тут main) на указнное колличество ms
            primitive_thread2.start();

            primitive_thread1.join();
            primitive_thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCounter()); // так как обращение не синхронизировано к общему объекту counter, происходят колизии
        System.out.println(sync_counter.getCounter()); // коллизий нет, т.к. synchronized
        System.out.println(list.size()); // так как обращение не синхронизировано к списку, происходят колизии
        System.out.println(sync_list1.getList().size()); // коллизий нет, т.к. synchronized
        System.out.println(sync_list2.size()); // коллизий нет, т.к. synchronized collections
    }
}


class Counter {
    int counter = 0;
    void incrementCounter() {
        counter++;
    };

    public int getCounter() {
        return counter;
    }
}

class SynchronizeCounter {
    int counter = 0;
    synchronized void incrementCounter() { // первый способ синхронизации на уровне метода
        counter++;
    };
    void decrementCounter() {
        synchronized (this){ // способ синхронизации на уровне куска кода (this - объект по монитору которого синхронизируемся)
            counter--;
        }
    };

    public int getCounter() {
        return counter;
    }

    static String value;
    synchronized static void setValue(String value) { // синхронизация статических методов
        SynchronizeCounter.value = value;
        synchronized (SynchronizeCounter.class){
            SynchronizeCounter.value = value;
        }
    };
}

class SynchronizeList {
    ArrayList<Integer> list;
    public SynchronizeList(ArrayList<Integer> list) {
        this.list = list;
    }

    synchronized void incrementList() { // первый способ синхронизации на уровне метода
        synchronized (list){
            list.add(list.size() + 1);
        }
    };

    public List<Integer> getList() {
        return List.copyOf(list);  // NB! возвращаем не мутирующуюся коллекцию - чтобы нельзя было изменить из вне
    }

}