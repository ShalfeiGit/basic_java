package app_11_class_and_objects;

public class ClassAndObjects {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.ram);
        System.out.println(computer.ssd);
        computer.load();
    }
}


class Computer {
    int ssd = 500;
    int ram =  1024;

    void load (){
        System.out.println("Computer loaded");
    }
}
