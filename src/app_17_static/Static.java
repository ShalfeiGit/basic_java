package app_17_static;

public class Static {
    public static void main(String[] args) {
        Test.showSeconds();
        Test test = new Test();
        Test test2 = new Test();
        System.out.println(Test.TEST_SECONDS);
        System.out.println(test.TEST_SECONDS == test2.TEST_SECONDS);
        System.out.println(test.TEST_SECONDS == test2.TEST_SECONDS);

        Class<? extends Test> clazz = test.getClass();
        System.out.println(clazz);
    }
}

class Test {
    public static int TEST_SECONDS = 100;
    public static void showSeconds() {
        System.out.println(Test.TEST_SECONDS);
    }
}
