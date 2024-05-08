package app_16_compositions;

public class Compositions {
    public static void main(String[] args) {
        Ram ram = new Ram();
        Ssd ssd = new Ssd();
        ram.setSize(1024);
        ssd.setSize(2048);
        Computer computer = new Computer(ram, ssd);
        computer.show();

    }
}
