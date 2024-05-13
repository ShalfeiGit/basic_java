package app_30_collections_iterator;

import app_24_oop_interfaces.Interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {
        Iterator<Integer> iterator_1 = new ArrayList<>(List.of(1, 2, 3, 4, 5)).iterator(); // List.of - не изменяемая коллекция (не доступен remove)
        Iterator<Integer> iterator_2 = List.of(1, 2, 3, 4, 5).iterator(); // List.of - не изменяемая коллекция (не доступен remove)
        Iterator<Integer> iterator_3 = List.of(1, 2, 3, 4, 5).iterator(); // List.of - не изменяемая коллекция (не доступен remove)

        for (; iterator_1.hasNext();){
            Integer next = iterator_1.next();
            if(next == 2) {
                iterator_1.remove();
            }
            System.out.print( next + " ");
        }

        System.out.println();
        iterator_2.forEachRemaining((item) -> System.out.print(item + " "));

        System.out.println();
        while(iterator_3.hasNext()){
            Integer next = iterator_3.next();
            System.out.print(next + " ");
        }
    }
}
