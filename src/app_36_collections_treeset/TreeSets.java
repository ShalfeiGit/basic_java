package app_36_collections_treeset;


import java.util.*;

public class TreeSets {
    public static void main(String[] args) {

        Set<Pet> treeSet = new TreeSet<>(); // строит красно бело дерево

        Pet pet1 = new Pet(1,"Vaska");
        Pet pet2 = new Pet(3,"Tuzik");
        Pet pet3 = new Pet(2, "Bulka");
        Pet pet4 = new Pet(4,"Korzhik");
        Pet pet5 = new Pet(5,"Laska");
        Pet pet6 = new Pet(6,"Ghorik");

        treeSet.add(pet1);
        treeSet.add(pet2);
        treeSet.add(pet3);
        treeSet.add(pet4);
        treeSet.add(pet5);
        treeSet.add(pet6);

        for(Pet pet: treeSet){
            System.out.print(pet + " ");
        }
        System.out.println();
        treeSet.iterator().forEachRemaining(pet -> System.out.print(pet + " "));
        System.out.println();
        treeSet.remove(1);
        System.out.println(treeSet.size());
        treeSet.iterator().forEachRemaining(id -> System.out.print(id + " "));
        System.out.println();
        treeSet.forEach(pet -> System.out.println(pet + " "));
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
