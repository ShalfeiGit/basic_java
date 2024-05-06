package app_04_if_else;

public class IfElse {
    public static void main(String[] args) {
        boolean a_1 = false;
        if(a_1){
            System.out.println("if #1");
        }

        if(!a_1){
            System.out.println("if #2");
        }else{
            System.out.println("else #3");
        }

        if(a_1){
            System.out.println("if #4");
        } else if (!a_1) {
            System.out.println("else #5");
        } else {
            System.out.println("else #6");
        }

        System.out.println(a_1 ? "ternary #1" : "ternary #2");
    }
}
