package app_47_stream_optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Optionals {
    public static void main(String[] args) {
        String list = Stream.of("b", "a", "d", "c")
                .reduce("", (acc, letter) -> letter == "c" ? letter : acc); // "" - начальное значение, преобразует в NotNullable (не нужен Optional)
        System.out.println(list);
        Optional<String> list2 = Stream.of("b", "a", "d", "c")
                .reduce((acc, letter) -> letter == "j" ? letter : acc); // использует первое значение в качестве начального
        System.out.println(list2);
        Optional<String> test = Stream.of("c", "a", "d", "l")
                .reduce((acc, letter) -> letter != "d" ? letter : acc);// reduce - преобразует к термирнальному значению
        System.out.println(test.isPresent());
        test.ifPresent(o -> System.out.println(o)); // запустить если есть
        test.ifPresentOrElse(o -> {System.out.println("o1");}, () -> { System.out.println("o2"); }); // Либ одно запусти, либ другое
        System.out.println(test.isPresent());
        System.out.println(test.isEmpty());
        System.out.println(test.get());
        System.out.println(test.filter(o -> !o.startsWith("d")));
        System.out.println(test.map(x-> null).flatMap(x -> Optional.of(x)).map(x -> {System.out.println(x); return x;})); // делает из потока Optionals, другой поток Optionals
    }
}
