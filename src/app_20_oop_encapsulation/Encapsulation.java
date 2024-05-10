package app_20_oop_encapsulation;

public class Encapsulation {
    public static void main(String[] args) { // ������������ - ��� �������� ������ � ��������� ���� �� ������������ ������
        Computer computer = new Computer();
        computer.setRam(12);
        System.out.println(computer.showDoubleRam());
    }
}

class Computer {
    private int ram;

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int showDoubleRam () {
        return ram * ram;
    }
}