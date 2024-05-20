package app_37_collections_dequeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Dequeues {
    public static void main(String[] args) {
        Deque<Pet> deque = new ArrayDeque<>(); // двусторон€€ очередь stack + queue

        Pet pet1 = new Pet(1,"Vaska");
        Pet pet2 = new Pet(3,"Tuzik");

        deque.addFirst(pet1);
        deque.addLast(pet2);

        Pet el1 = deque.getLast();
        Pet el2 = deque.getFirst();
        deque.removeFirst();
        deque.removeLast();

        System.out.println(el1.getName());
        System.out.println(el2.getName());
    }
}

class Pet {
    private Integer id;
    private String name;

    public Pet(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(name, pet.name);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
