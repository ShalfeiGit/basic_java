package app_22_oop_polymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.setName("Murzik");

        Animal dog = new Dog();
        dog.setName("Sharik");
//        Animal.showAnimals(new Animal[]{cat, dog});
        Animal.showAnimals(cat, dog);

    }
}

abstract class Animal{
    String name;
    public String getName(){
        return name;
    };
    public abstract void setName(String name);

//    public static void showAnimals(Animal[] animals) {
//        for(Animal animal : animals){
//            System.out.println(animal.getName());
//        }
//    };
    public static void showAnimals(Animal... animals) {
        for(Animal animal : animals){
            if(animal instanceof Cat){ // проверка на пренадлежность классу
                ((Cat) animal).setName("Cat: " + animal.name + "2"); // кастинг класса для инстанса
            }
            System.out.println(animal.getName());
        }
    };



}

class Cat extends Animal {

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {

    @Override
    public void setName(String name) {
        this.name = "Dog: " + name;
    }
}

