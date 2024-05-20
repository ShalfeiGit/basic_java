package app_38_collections_identityHashMaps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IdentityHashMaps {
    public static void main(String[] args) {
        IdentityHashMap<Integer, Pet> identityHashMap = new IdentityHashMap<>(); // аналог HashMap не нужно преопередлять equals и hashcode, т.к сравнение идет по ссылке

        Pet pet1 = new Pet(1,"Vaska");
        identityHashMap.put(pet1.getId(), pet1); // см. hashMap
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

