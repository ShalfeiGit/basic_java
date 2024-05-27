package app_45_stream_lamda;


import java.util.Comparator;
import java.util.function.*;

public class Lamdas {
    public static void main(String[] args) {
        TestFunctionalInterface<String> lambda_1 = o1 -> "Hello, " + o1; // ��������� ������ ��������� 1
        System.out.println(lambda_1.test("Valentin"));

        TestFunctionalInterface2<Integer> lambda_2 = (o1, o2) -> Integer.compare(o1, o2); // ��������� ������ ��������� 2
        System.out.println(lambda_2.test(1, 2));

        TestFunctionalInterface2<Integer> lambda_3 = Integer::compare; // ��������� ������ ��������� 3 (����������� ����� ������ ���� �� ��������� �� ����� ������������� ������ � java)
        System.out.println(lambda_3.test(1, 2));

        TestFunctionalExample test = new TestFunctionalExample();
        TestFunctionalInterface2<Integer> lambda_4 = test::somebodyMethods; // ��������� ������ ��������� 4 (����������� ����� ������ ���� �� ��������� �� ����� ���������� ������ ������)
        System.out.println(lambda_4.test(1, 2));

        //��������� � java ������� ����������� FunctionalInterface
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2); // input: any, any return: int
        System.out.println(comparator.compare(2, 1));

        Function<Integer, String> function = o1 -> o1 + " "; // input: any, return: any
        System.out.println(function.apply(3));

        Predicate<Integer> predicate = o1 -> o1 > 4; // input: any, return: boolean
        System.out.println(predicate.test(3));

        Consumer<Integer> consumer = o1 -> {  // input: any, return: void (����� �� setter)
            System.out.println( o1);
        };
        consumer.accept(5);

        Supplier<Integer> supplier = () -> 6; // input: void, return: any (����� �� getter)
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, String> biFunction = (o1, o2) -> o1 + o2 + " "; // input: any, any; return: any
        System.out.println(biFunction.apply(3, 4));

        Runnable runnable = () -> { // input: void; return: void
            System.out.println("Running");
        };
        runnable.run();
    }
}

class TestFunctionalExample {
    public int somebodyMethods(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}


