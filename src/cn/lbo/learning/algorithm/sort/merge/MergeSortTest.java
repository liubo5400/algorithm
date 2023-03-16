package cn.lbo.learning.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
