package app_43_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(6);
        arrayList1.add(3);
        arrayList1.add(5);

        List<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(6);
        arrayList2.add(3);
        arrayList2.add(5);


        List<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(1);
        arrayList3.add(2);
        arrayList3.add(6);
        arrayList3.add(3);
        arrayList3.add(5);


        List<Pet> arrayList4 = new ArrayList<>();
        Pet pet1 = new Pet(1,"Vaska");
        Pet pet2 = new Pet(3,"Tuzik");
        Pet pet3 = new Pet(2, "Bulka");
        Pet pet4 = new Pet(4,"Korzhik");
        arrayList4.add(pet1);
        arrayList4.add(pet2);
        arrayList4.add(pet3);
        arrayList4.add(pet4);

        List<Pet> arrayList5 = new ArrayList<>();
        Pet pet5 = new Pet(1,"Vaska");
        Pet pet6 = new Pet(3,"Tuzik");
        Pet pet7 = new Pet(2, "Bulka");
        Pet pet8 = new Pet(4,"Korzhik");
        arrayList5.add(pet5);
        arrayList5.add(pet6);
        arrayList5.add(pet7);
        arrayList5.add(pet8);

        //Вариант первый
        arrayList1.sort((o1, o2) -> o1 - o2);

        //Вариант второй
        arrayList2.sort((o1, o2) -> Integer.compare(o1, o2));

        //Вариант третий
        Collections.sort(arrayList3);

        //Вариант четвёртый
        Collections.sort(arrayList4);

        //Вариант пятый
        Collections.sort(arrayList5, new PetComparator());

        System.out.println(arrayList1);
        System.out.println(arrayList2);
        System.out.println(arrayList3);
        System.out.println(arrayList4);
        System.out.println(arrayList5);
    }
}

class Pet implements Comparable<Pet> {
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

    @Override
    public int compareTo(Pet pet) {
        return Integer.compare(this.getId(), pet.getId());
    }
}

class PetComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
