package app_23_oop_abstract_classes;

public class AbstractClasses {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Murzik");
        System.out.println(cat.getName());
    }
}

abstract class Animal{
    String name;
    public String getName(){
        return name;
    };
    public abstract String setName(String name);
}

class Cat extends Animal{

    @Override
    public String setName(String name) {
        return this.name = name;
    }
}
