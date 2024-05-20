package app_40_collections_vector;

import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<Pet> vector = new Vector<>(); // старая версия ArrayList
        Pet pet1 = new Pet(1,"Vaska");
        vector.add(pet1);
        Pet el = vector.get(0);

        System.out.println(el);
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
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
