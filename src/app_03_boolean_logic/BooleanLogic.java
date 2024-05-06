package app_03_boolean_logic;

public class BooleanLogic {
    public static void main(String[] args) {
        boolean a_1 = true;
        boolean a_2 = 10 < 1;
        boolean a_3 = 10 >= 1;
        boolean a_4 = 10 != 1;
        boolean a_5 = 10 == 1;

        boolean b_1 = a_1 && a_2;
        boolean b_2 = a_1 || a_2;
        boolean b_3 = !a_1;

        System.out.println(a_1);
        System.out.println(a_2);
        System.out.println(a_3);
        System.out.println(a_4);
        System.out.println(a_5);

        System.out.println(b_1);
        System.out.println(b_2);
        System.out.println(b_3);
    }
}
