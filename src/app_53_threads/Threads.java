package app_53_threads;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        // 1 - спопосб задания потока
        Thread myThread_1 = new MyThread();
        // 2 - спопосб задания потока
        Thread myThread_2 = new Thread(new RunnableThread());
        // 3 - спопосб задания потока
        Thread myThread_3 = new Thread(() -> {Thread.currentThread().setName("LambdaThread");  System.out.println(Thread.currentThread().getName());});

        myThread_1.start(); // новый поток
        myThread_1.join(); // заставить основной поток main дожидаться завершения потока mythread
        myThread_1.interrupt(); // закрыть поток по его завершению, либо сам закроется по егозавершению
        myThread_2.start();
        myThread_2.join();
        myThread_3.start();
        myThread_3.join();

        // 4- основной поток main
        System.out.println(Thread.currentThread().getName()); // исходный поток main
        System.out.println(Thread.currentThread().getState()); // получить состтояние потока  (NEW - создан, RUNNABLE - запущен, BLOCKED - блокирован дроугим потоком, WAITING - ожидает (join), TIME_WAITING - ожидает указанное колличество ms (join(100L)) TERMINATED- завершен)

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        setName("CustomThread");
        System.out.println(Thread.currentThread().getName());
    }
}

class RunnableThread implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("RunnableThread");
        System.out.println(Thread.currentThread().getName());
    }
}
