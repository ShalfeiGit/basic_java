package app_26_oop_enums;

import java.util.Arrays;

public class Enums {
    public static void main(String[] args) {
        System.out.println(TestEnum_1.Test_A);
        System.out.println(TestEnum_1.Test_B.name());
        System.out.println(TestEnum_1.Test_C.toString());
        System.out.println(TestEnum_1.valueOf("Test_D"));
        System.out.println(Arrays.toString(TestEnum_1.values())); // ����� ������� ������ ���� enums
        System.out.println(TestEnum_1.Test_E.ordinal()); //����� ��������� ������

        System.out.println(TestEnum_2.Test_A.getTest());
        TestEnum_2.Test_A.getTest2();
    }
}

enum TestEnum_1 {
    Test_A, Test_B, Test_C, Test_D, Test_E;
}


enum TestEnum_2 implements TestEnums_2_interface { // �� ����������� �������������� enum, ������ ��������� �������
    Test_A("test"){
        @Override
        public void getTest2() {
            System.out.println("run getTest2");
        }
    };
    private String test;

    TestEnum_2(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    @Override // ������ ������� ���������� ������
    public void getTest2() {
        System.out.println("run getTest2.1");
    }
}

interface TestEnums_2_interface {
    void getTest2();
}
