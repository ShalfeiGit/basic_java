package ControlStructures_2;

public class ControlStructures {

  public static void main(String[] args) {
    var count = 3;
    // Example 1 (if-else)
    if (count > 2) {
      System.out.println("Count is higher than 2");
    } else {
      System.out.println("Count is lower or equal than 2");
    }
    // Example 2 (ternary)
      System.out.println(count > 2 ? "Count is higher than 2" : "Count is lower or equal than 2");
    // Example 3 (switch)
    switch (count) {
      case 1:
        System.out.println("Count is 1");
        break;
      case 2:
        System.out.println("Count is 2");
        break;
      default:
        System.out.println("Count is higher than 2");
    }
    // Example 4 (for loop)
    for (int i = 1; i < 3; i++) {
      if(i == 2){
        break;
      }
      System.out.println("Count is less than 2");
    }
    //Example 5 (while loop)
    int j = 1;
    while (j < 3) {
      if(j == 2){
        j++;
        continue;
      }
      System.out.println("Count is less than 2");
      j++;
    }

    //Example 6 (do-while loop)
    int k = 1;
    do {
      if(k == 2){
        k++;
        continue;
      }
      System.out.println("Count is less than 2");
      k++;
    } while (k < 3);

  }
}
