package app_38_collections_identityHashMaps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IdentityHashMaps {
    public static void main(String[] args) {
        IdentityHashMap<Integer, Pet> identityHashMap = new IdentityHashMap<>(); // ������ HashMap �� ����� ������������� equals � hashcode, �.� ��������� ���� �� ������

        Pet pet1 = new Pet(1,"Vaska");
        identityHashMap.put(pet1.getId(), pet1); // ��. hashMap
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

