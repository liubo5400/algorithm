package cn.lbo.learning.algorithm.sort.insertion;

import java.util.Arrays;

public class InsertionSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
