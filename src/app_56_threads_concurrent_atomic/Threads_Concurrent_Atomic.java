package app_56_threads_concurrent_atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Threads_Concurrent_Atomic {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0); // Atomic полная хуйня  - не использовать в работе
        AtomicBoolean bool = new AtomicBoolean(false);
        AtomicIntegerArray intArray = new AtomicIntegerArray(new int[10]);
        AtomicReferenceArray StringArray = new AtomicReferenceArray(new String[10]);
        Thread thread_1 = new Thread(() -> {
            int value = count.get();
            while(value < 10){
                intArray.set(value , value );
                StringArray.set(value , new String("" +value ));
                bool.set(false);
                value = count.incrementAndGet();
            }
            System.out.println("Thread_1: intArray " + intArray);
            System.out.println("Thread_1: StringArray " + StringArray);
            System.out.println("Thread_1: bool " + bool.get());
            System.out.println("Thread_1: count " + count.get());

        });
        Thread thread_2 = new Thread(() -> {
            int value = count.get();
            while(value < 10){
                intArray.set(value, value);
                StringArray.set(value, new String("" + value));
                bool.set(false);
                value = count.incrementAndGet();
            }
            System.out.println("Thread_2: intArray " + intArray);
            System.out.println("Thread_2: StringArray " + StringArray);
            System.out.println("Thread_2: bool " + bool.get());
            System.out.println("Thread_2: count " + count.get());
        });

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
    }
}
