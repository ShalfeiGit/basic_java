package app_28_collections_array_list;

// �������� O-���������� �� ������ � ������:
// O(1) - ������: ������ ���������� ��������
// O(log(n)) - ������: �������� ���c� ��������
// O(n) - ������: ����� �������� � ������� �� ��������
// O(nlog(n)) - ������: ������� ����������
// O(nlog(n)) - ������: ������� ����������
// O(n^2) - ������: ���������� ��������� ��� ������� ��������� ��������
// O(2^n) - ������: Tower of Hanoi https://dev.to/lofiandcode/big-o-part-5-2-n-2ifn
// O(n!) - ������: ����������� ������� � ����� ��������  https://dev.to/lofiandcode/big-o-part-6-n-58e3

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
