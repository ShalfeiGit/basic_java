package app_07_while;

public class While {
    public static void main(String[] args) {
        int countWhile = 0;
         while (countWhile < 1) {
             System.out.println("Test while: " + countWhile);
             countWhile += 1;
         }
         int countDoWhile = 0;
         do { // в любом случае выполнится хоят бы один раз(даже если условие не проходит),а так аналогичен while
             System.out.println("Test do-while: " + countDoWhile);
             countDoWhile += 1;
         }  while (countDoWhile < 1);
    }
}
