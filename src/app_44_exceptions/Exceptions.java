package app_44_exceptions;

import java.io.FileNotFoundException;

public class Exceptions {
    public static void main(String[] args) throws FileNotFoundException { //��������� ���� ���
        TestException.test();
        try { //��������� ��� ���
            TestException.test2();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage()); // ���� ������ � ����� ������ - System.out.println, ������ �����
            e.printStackTrace(); // ������ ������ ������

        }
        TestException.test3();
    }
}

class TestException {
    public static void test(){
        try { // ������ �������
            int a = 10;
            int b = 0;
            throw new RuntimeException("Exceptions"); // ������� ������
        } catch (Throwable e) { // ��������� �������� ������ RuntimeException | ArithmeticException | IllegalArgumentException | FileNotFoundException | Exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }

    public static void test2 () throws RuntimeException{ // �� ������� �������� � ���������� ������
        int a = 10;
        int b = 0;
        throw new RuntimeException("RuntimeException");
    }

    public static void test3 () throws FileNotFoundException { // ������� �������� � ���������� ������
        int a = 10;
        int b = 0;
        throw new FileNotFoundException("Exceptions");
    }


}
