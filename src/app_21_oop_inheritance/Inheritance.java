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

final class Laptop extends Computer { //����� � ������ ������������� �� Laptop
    public Laptop(int ram) {
        super(ram);
    }

    public Laptop(){
        // ����� ������� ��� super �.�. ������� ��������� ����������� ��������� ������
    }

    {
        System.out.println("���� ������������� Laptop, ��� ������������� ���������� (����� ����� ������������� ������)");
    }
    static {
        System.out.println("����������� ���� ������������� Laptop, ��� ����������� ������������� ����������, (����� ����� ������������� ������)");
    }

    public int getSsd() {
        this.getRam(); //����� ������������� ������
        this.ssd = 512;
        return super.ssd;
    }
}
