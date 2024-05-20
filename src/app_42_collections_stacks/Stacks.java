package app_42_collections_stacks;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Pet> stack = new Stack<>(); // утсарелая верси dequeue
        Pet pet1 = new Pet(1,"Vaska");
        stack.push(pet1);
        Pet el = stack.pop();
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

