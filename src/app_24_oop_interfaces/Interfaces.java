package app_24_oop_interfaces;

public class Interfaces implements Test { // интерфейсы в отличии от абсткратных классов - позвол€ют множественную реализацию (extends vs implements)
    public static void main(String[] args) {
        Interfaces custom_interface = new Interfaces();
        custom_interface.test2();
        custom_interface.test5();
    }
    public void test5(){
        System.out.println("run test5");
    }
}
