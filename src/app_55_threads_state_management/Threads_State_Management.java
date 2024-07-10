package app_55_threads_state_management;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Threads_State_Management {
    private static volatile int lastNumber;
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        try {
            Thread producer_thread = new Thread(() -> {
                while(true){
                    synchronized (linkedList) {
                        if(linkedList.size() < 10){
                                int number = (int) (Math.random() * 100);
                                lastNumber = number;
                                linkedList.add(number);
                                System.out.println("Producer add number: " + number +", current queue: " + linkedList);
                            try {
                                int timer = (int) (Math.random() * 1000);
                                linkedList.wait(timer);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            try {
                                System.out.println("Producer wait vacancies");
                                linkedList.wait(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            });

            Thread consumer_thread = new Thread(() -> {
                while(true){
                    synchronized (linkedList) {
                        if(!linkedList.isEmpty()){
                            lastNumber = (Integer) linkedList.getLast();
                            linkedList.removeLast();
                                System.out.println("Comsumer remove number: " + lastNumber +", current queue: " + linkedList);
                                try {
                                    int timer = (int) (Math.random() * 1000);
                                    linkedList.wait(timer);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                        } else {
                            try {
                                System.out.println("Consumer wait number");
                                linkedList.wait(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }
            });

            producer_thread.start();
            consumer_thread.start();
            producer_thread.join();
            consumer_thread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
