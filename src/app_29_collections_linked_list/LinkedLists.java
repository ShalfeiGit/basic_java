package app_29_collections_linked_list;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("size: " + linkedList.size());


        System.out.println(linkedList.get(0));  // O(1)
        System.out.println(linkedList.contains(2)); // O(n)
        linkedList.remove((Integer) 2); // O(n)
        linkedList.forEach(i -> System.out.print("Element: " + i + ", ")); // O(n)
    }
}
