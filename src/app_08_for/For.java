package app_08_for;

public class For {
    public static void main(String[] args) {

        for(int i = 0; i < 4; i++){
            if(i == 3){
                continue; // переходим на след цикл итерации
            }
            System.out.println(i);
        }

        String str = "Test";
        for(char c : str.toCharArray()){
            System.out.print(c + "  ");
        }
    }
}
