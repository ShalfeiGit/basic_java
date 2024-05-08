package app_16_compositions;

public class Computer {
    private Ram ram;
    private Ssd ssd;

    public Computer(Ram ram, Ssd ssd) {
        this.ram = ram;
        this.ssd = ssd;
    }

    public void show() {
        System.out.println("Computer params: " + ram.getSize()+ " -ram " + ssd.getSize() + " -ssd " );
    }
}
