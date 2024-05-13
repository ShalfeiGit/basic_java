package app_27_oop_generics;

import app_18_string.Strings;

public class Generics {
    public static void main(String[] args) {
        Animal<? super Animal_Type> animal = new Animal<>(); // super == текущий класс + все предки, учеутвы только все предки
        Animal_Type animal_type = new Animal_Type("chordates", "bone");
        System.out.println(animal.getAnimalInfo(animal_type));
    }
}


class Animal<T extends Animal_Type> implements Animal_Kingdom<T>{

    public T getAnimalInfo(T animal){
        System.out.println("Animal type: " + animal.animal_type + ", Animal class:" + animal.animal_class);
        return animal;
    }
}

class Animal_Type<T extends String> extends Animal_Class<T> {
    public Animal_Type(T animal_type, T animal_class) {
        this.animal_type = animal_type;
        this.animal_class = animal_class;
    }
    T animal_type;
}

class Animal_Class<T> {
    T animal_class;
}

interface Animal_Kingdom<T> {
    public T getAnimalInfo(T animal); // дженерики в интерфейсах не используются со статическими переменными например T type = "Kingdom"; но это работает в класса

}

