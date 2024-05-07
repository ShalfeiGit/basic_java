package app_13_method_overloading;

public class MethodOverloading {
    public static void main(String[] args) {
        Home home = new Home();
        System.out.println(home.build());
        System.out.println(home.build(1));
        System.out.println(home.build(1, 2L));
        System.out.println(home.build(2L, 1));
        System.out.println(home.build(2L));
    }
}

class Home {

    int windows;
    long doors;

    String build(){
        return "Дом построен";
    }

    String build(int windows){
        return "Дом 2 построен";
    }

    String build(int windows, long doors){
        return "Дом 3 построен";
    }

    String build(long doors, int windows){
        return "Дом 4 построен";
    }

    String build(long doors){
        return "Дом 5 построен";
    }
}
