package app_24_oop_interfaces;

public interface Test {
    static String test4() {
        return "run test4";
    }
    String CONSTANT_TEST = "run test"; // �� ������ ��������� � ������������ public static final
    void test5();
    default void test2(){
        System.out.println(Test.CONSTANT_TEST);
        System.out.println("run test2"); // �������� ��������� ��������� ������ � ����� � �����������
        test3();
        System.out.println(Test.test4());;

    };
    private void test3(){
        System.out.println("run test3"); // ���������� ������� �� �������� �����, �� �������� ������ ����������
    }
}
