package app_10_arrays;

public class Arrays {
    public static void main(String[] args) {
        int[] a_1 = new int[10];
        int[] a_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        a_1[0] = 1;

        System.out.println("a_1[0]: " + a_1[0]);
        System.out.println("a_2[2]: " +  a_2[2]);
        System.out.println("a_2.length: " + a_2.length);

        int[][] a_3 = {{1,2}, null, new int[4], {7,8}};
        System.out.println("a_1[3][1]: " +a_3[3][1]);
        System.out.println("a_3[1]: " + a_3[1]);

        for(int item: a_2){
            System.out.print(item + " ");
        }
        System.out.println();
        for(int i = 0; i < a_2.length; i++){
            System.out.print(a_2[i] + " ");
        }
    }
}
