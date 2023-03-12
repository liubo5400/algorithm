package cn.lbo.learning.algorithm.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序测试
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
