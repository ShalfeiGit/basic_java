package app_24_oop_interfaces;

public interface Test {
    static String test4() {
        return "run test4";
    }
    String CONSTANT_TEST = "run test"; // по началу константы в интферфейсах public static final
    void test5();
    default void test2(){
        System.out.println(Test.CONSTANT_TEST);
        System.out.println("run test2"); // возможно создавать дефолтные методы с телом в интерфейсах
        test3();
        System.out.println(Test.test4());;

    };
    private void test3(){
        System.out.println("run test3"); // примватные ментоды не доступны извне, но доступны внутри интерфейса
    }
}
