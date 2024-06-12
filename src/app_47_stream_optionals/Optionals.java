package app_47_stream_optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Optionals {
    public static void main(String[] args) {
        String list = Stream.of("b", "a", "d", "c")
                .reduce("", (acc, letter) -> letter == "c" ? letter : acc); // "" - ��������� ��������, ����������� � NotNullable (�� ����� Optional)
        System.out.println(list);
        Optional<String> list2 = Stream.of("b", "a", "d", "c")
                .reduce((acc, letter) -> letter == "j" ? letter : acc); // ���������� ������ �������� � �������� ����������
        System.out.println(list2);
        Optional<String> test = Stream.of("c", "a", "d", "l")
                .reduce((acc, letter) -> letter != "d" ? letter : acc);// reduce - ����������� � �������������� ��������
        System.out.println(test.isPresent());
        test.ifPresent(o -> System.out.println(o)); // ��������� ���� ����
        test.ifPresentOrElse(o -> {System.out.println("o1");}, () -> { System.out.println("o2"); }); // ��� ���� �������, ��� ������
        System.out.println(test.isPresent());
        System.out.println(test.isEmpty());
        System.out.println(test.get());
        System.out.println(test.filter(o -> !o.startsWith("d")));
        System.out.println(test.map(x-> null).flatMap(x -> Optional.of(x)).map(x -> {System.out.println(x); return x;})); // ������ �� ������ Optionals, ������ ����� Optionals
    }
}
