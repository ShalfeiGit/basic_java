package types;

public class DataTypes {
  public static void main(String[] args) {
    //Primitive data types
    int a = 10;
    byte b = 10;
    short c = 10;
    long d = 10L;
    float e = 10.0f;
    double f = 10.0;
    boolean j = true;
    char h = 'A';
    char h2 = 65;
    char h3 = '\uffff';

    System.out.println(a + " " + b + " " + d  + " " + c + " " + d + " " + e + " " + f + " " + j + " " + h + " " + h2 + " " + h3);

    //Reference data types
    String k = "Hello";
    System.out.println(k);

    //Array data types
    int[] l = {10, 20, 30};
    int[] l1 = new int[]{10, 20, 30};
    int[] l2 = new int[3];

    System.out.println(l);
    System.out.println(l1);
    System.out.println(l2);

  }
}
