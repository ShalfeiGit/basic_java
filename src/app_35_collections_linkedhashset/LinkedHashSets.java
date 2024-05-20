package app_35_collections_linkedhashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedHashSets {
    public static void main(String[] args) {
        Set<Pet> linkedHashSet = new LinkedHashSet<>(); // ѕор€док при итерации по map не гарантируетс€
        Pet pet1 = new Pet(1,"Vaska");
        Pet pet2 = new Pet(3,"Tuzik");
        Pet pet3 = new Pet(2, "Bulka");
        Pet pet4 = new Pet(4,"Korzhik");
        linkedHashSet.add(pet1);
        linkedHashSet.add(pet2);
        linkedHashSet.add(pet3);
        linkedHashSet.add(pet4);

        for (Pet pet: linkedHashSet) {
            System.out.print(pet + " ");
        }
        System.out.println();
        linkedHashSet.iterator().forEachRemaining(pet -> System.out.print(pet + " "));
        System.out.println();
        linkedHashSet.remove(1);
        System.out.println(linkedHashSet.size());
        linkedHashSet.iterator().forEachRemaining(id -> System.out.print(id + " "));
        System.out.println();
        linkedHashSet.forEach(pet -> System.out.print(pet + " "));
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