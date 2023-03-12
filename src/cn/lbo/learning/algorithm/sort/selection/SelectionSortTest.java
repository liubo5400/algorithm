package cn.lbo.learning.algorithm.sort.selection;

import java.util.Arrays;

/**
 * 选择排序测试
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
