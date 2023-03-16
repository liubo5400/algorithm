package cn.lbo.learning.algorithm.sort.quick;

import cn.lbo.learning.algorithm.sort.selection.SelectionSort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
