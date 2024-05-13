package app_28_collections_array_list;

// Варианты O-нотификаци от лучшей к худшим:
// O(1) - пример: массив доавбление элемента
// O(log(n)) - пример: бинарный посик элемента
// O(n) - пример: поиск элемента в массиве по значению
// O(nlog(n)) - пример: быстрая сортировка
// O(nlog(n)) - пример: быстрая сортировка
// O(n^2) - пример: сотрировка пузырьком или перебор двумерных массивов
// O(2^n) - пример: Tower of Hanoi https://dev.to/lofiandcode/big-o-part-5-2-n-2ifn
// O(n!) - пример: рекурсивная функция в цикле например  https://dev.to/lofiandcode/big-o-part-6-n-58e3

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);    // O(1)
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList.get(0));  // O(1)
        System.out.println(arrayList.contains(2)); // O(n)
        arrayList.remove((Integer) 2); // O(n)
        arrayList.forEach(i -> System.out.print("Element: " + i + ", ")); // O(n)
    }
}
