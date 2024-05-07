package app_12_constructors;

public class Constructors {
    public static void main(String[] args) {
        Home home = new Home();
        Home home1 = new Home(1);
        Home home2 = new Home(2, 3);
        System.out.println("home-windows: " + home.windows);
        System.out.println("home-windows: " + home.doors);
        System.out.println("home1-windows: " + home1.windows);
        System.out.println("home2-windows: " + home2.windows);
        System.out.println("home2-windows: " + home2.doors);
    }
}

class Home {

    int windows;
    int doors;

    Home(int windows, int doors) {

        System.out.println("Конструктор создался с окнами и дверями");
        this.windows = windows;
        this.doors = doors;
    }

    Home(int windows) {
        System.out.println("Конструктор создался с окнами");
        this.windows = windows;
    }

    Home(){
        System.out.println("Конструктор создался без папраметров");
    }
}
