package cn.lbo.learning.algorithm.sort.shell;

import java.util.Arrays;

public class ShellSortTest {

    public static void main(String[] args) {
        Integer[] a = {3, 5, 6, 2, 1, 4, 7};
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
