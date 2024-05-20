package app_32_collections_linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LinkedHashMaps {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", 18, 1);
        Person person2 = new Person("Petr", 21, 3);
        Person person3 = new Person("Andrew", 16, 2);

        Map<Integer, Person> linkedHashMap = new LinkedHashMap<>(); // ѕор€док при итерации по map гарантируетс€

        linkedHashMap.put(person1.getId(), person1);
        linkedHashMap.put(person2.getId(), person2);
        linkedHashMap.put(person3.getId(), person3);

        for(Map.Entry<Integer, Person> person: linkedHashMap.entrySet()){
            System.out.print(person + " ");
        }
        System.out.println();
        linkedHashMap.values().iterator().forEachRemaining(pet -> System.out.print(pet + " "));
        System.out.println();
        linkedHashMap.remove(1);
        System.out.println(linkedHashMap.size());
        linkedHashMap.keySet().iterator().forEachRemaining(id -> System.out.print(id + " "));
        System.out.println();
        System.out.println(linkedHashMap.get(2));
        linkedHashMap.forEach((key, person) -> System.out.println(person + " "));
    }
}

class Person {
    private String name;
    private int age;
    private int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
