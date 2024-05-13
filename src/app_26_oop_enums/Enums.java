package app_26_oop_enums;

import java.util.Arrays;

public class Enums {
    public static void main(String[] args) {
        System.out.println(TestEnum_1.Test_A);
        System.out.println(TestEnum_1.Test_B.name());
        System.out.println(TestEnum_1.Test_C.toString());
        System.out.println(TestEnum_1.valueOf("Test_D"));
        System.out.println(Arrays.toString(TestEnum_1.values())); // вывод строкой список всех enums
        System.out.println(TestEnum_1.Test_E.ordinal()); //вывод порядкого номера

        System.out.println(TestEnum_2.Test_A.getTest());
        TestEnum_2.Test_A.getTest2();
    }
}

enum TestEnum_1 {
    Test_A, Test_B, Test_C, Test_D, Test_E;
}


enum TestEnum_2 implements TestEnums_2_interface { // не стандартное исипользование enum, аналог абстарных классов
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

    @Override // второй вариант перезаписа метода
    public void getTest2() {
        System.out.println("run getTest2.1");
    }
}

interface TestEnums_2_interface {
    void getTest2();
}
