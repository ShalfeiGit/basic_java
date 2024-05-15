package app_30_collections_iterator;

import app_24_oop_interfaces.Interfaces;

import java.util.*;

public class Iterators {
    public static void main(String[] args) {
        Iterator<Integer> iterator_1 = new ArrayList<>(List.of(1, 2, 3, 4, 5)).iterator(); // List.of - �� ���������� ��������� (�� �������� remove) ArrayList - ������ ���������� ����������
        Iterator<Integer> iterator_2 = Arrays.asList(1, 2, 3, 4, 5).iterator(); // List.of - �� ���������� ��������� (�� �������� remove) Arrays.asList - ������ ���������� ����������
        Iterator<Integer> iterator_3 = List.of(1, 2, 3, 4, 5).iterator(); // List.of - �� ���������� ��������� (�� �������� remove)

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
