package app_46_stream_collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collections {
    public static void main(String[] args) {
        // Create
        List<String> list_3 = Stream.of("b", "a", "d", "c").map(o1 -> o1 + " ").peek(System.out::print).collect(Collectors.toList()); // peek - не терминальный метод
        System.out.println();
        List<Integer> list_4 = IntStream.of(1, 2, 3, 4).map(o1 -> o1).peek(System.out::print).boxed().collect(Collectors.toList());
        System.out.println();
        // Usage
        List<String> list = Arrays.asList("b", "a", "d", "c");
        List<String> list2 = list.stream()
                .sequential() // - выполнять в одном потоке
                .parallel() // - выполнять в паралелльных потоках
                .map(o1 -> o1 + ", ")
                .filter(o -> !o.startsWith("c"))
                .sorted((o1, o2) -> o1.compareTo(o2))
                .skip(1)
                .limit(2)
                .collect(Collectors.toList()); // выдает коллекцию на выход

        list2.stream().forEach(System.out::print); // forEach - терминальный метод
        System.out.println();

        for (String s: list2) {
            System.out.print(s);
        }

        System.out.println();
        List<String> list_5 = Stream.of(new Pet("Juk"), new Pet("Kol"), new Pet("Loki")).flatMap(x -> Stream.of(x.getName())).collect(Collectors.toList()); //flatMap - деаем из потока одних данных, поток других данных
        System.out.println(list_5);

        Stream<String> list_6 = Stream.of("a", "b");
        Stream.concat(list_6, Stream.of("c")).forEach(System.out::print);
    }
}

class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public Pet(String name) {
        this.name = name;
    }
}
