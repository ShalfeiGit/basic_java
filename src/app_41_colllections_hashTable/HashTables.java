package app_41_colllections_hashTable;

import java.util.Hashtable;

public class HashTables {
    public static void main(String[] args) {
        Hashtable<Integer, Pet> hashTable = new Hashtable<>(); // устарелая версия hashMap
        Pet pet1 = new Pet(1,"Vaska");
        hashTable.put(pet1.getId(), pet1);
        Pet el = hashTable.get(1);

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
