package app_44_exceptions;

import java.io.FileNotFoundException;

public class Exceptions {
    public static void main(String[] args) throws FileNotFoundException { //обработка либо так
        TestException.test();
        try { //обработка или так
            TestException.test2();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage()); // выод ошибки в одном потоке - System.out.println, дрйгой поток
            e.printStackTrace(); // аналог вывода ошибки

        }
        TestException.test3();
    }
}

class TestException {
    public static void test(){
        try { // первый вариант
            int a = 10;
            int b = 0;
            throw new RuntimeException("Exceptions"); // бросить ошибку
        } catch (Throwable e) { // возможные варианты ощибок RuntimeException | ArithmeticException | IllegalArgumentException | FileNotFoundException | Exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }

    public static void test2 () throws RuntimeException{ // не требует проверки в вызываемом классе
        int a = 10;
        int b = 0;
        throw new RuntimeException("RuntimeException");
    }

    public static void test3 () throws FileNotFoundException { // требует проверки в вызываемом классе
        int a = 10;
        int b = 0;
        throw new FileNotFoundException("Exceptions");
    }


}
