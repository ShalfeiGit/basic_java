package app_21_oop_inheritance;

public class Inheritance {
    public static void main(String[] args) {
        Laptop laptop   = new Laptop(1024);
        System.out.println(laptop.getRam());
        System.out.println(laptop.getSsd());
    }
}

class Computer {
    private int ram;
    public int ssd = 2048;

    public Computer(int ram) {
        this.ram = ram;
    }

    public Computer(){}

    public int getRam() {
        return ram;
    }
}

final class Laptop extends Computer { //никто е сможет наследоваться от Laptop
    public Laptop(int ram) {
        super(ram);
    }

    public Laptop(){
        // можем вызвать без super т.к. имеется дефолтный конструктор бьазового класса
    }

    {
        System.out.println("блок инициализации Laptop, для инициализации переменных (вызов перед конструктором класса)");
    }
    static {
        System.out.println("статический блок инициализации Laptop, для статических инициализации переменных, (вызов перед конструктором класса)");
    }

    public int getSsd() {
        this.getRam(); //вызов родительского метода
        this.ssd = 512;
        return super.ssd;
    }
}
