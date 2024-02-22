package cn.lbo.learning.algorithm.sort.selection;

import java.util.Arrays;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:43
 * @PackageName:cn.lbo.learning.algorithm.sort.selection
 * @ClassName: SelectionSort
 * @Description: 选择排序
 * @原理：
 * 1、每一次遍历过程中，都假定第一个索引处元素是最小值，和其他索引处的值依次比较，如果当前索引大于其他索引处的值，
 * 则假定其他某个索引处的值是最小值，最后可以找到最小值所在索引位置。
 * 2、交换第一个索引处和最小值所在索引处的值。
 * @时间复杂度： O(N ^ 2)
 * @Version 1.0
 */
public class SelectionSort {

    /**
     * 对a数组进行排序
     * 从第一个元素到倒数第二个元素，每次遍历都找到最小值所在索引位置，然后交换索引i和最小值所在索引minIndex的值
     * 最小值在最左边
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i <= a.length - 2; i++) { // 每遍历一次，参与比较的元素减少一个，直到数组中倒数第二个元素为止
            int minIndex = i;//定义一个最小值所在索引位置，默认取数组第一个索引
            for (int j = i + 1; j < a.length; j++) { //依次比较剩余元素，从i+1索引位置开始
                if (greater(a[minIndex], a[j])) { //判断最小值索引
                    minIndex = j; //交换最小值索引
                }
            }
            exch(a, i, minIndex);//交换索引i和最小值所在索引minIndex的值
            System.out.print(i + " " + minIndex + "   ");
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 判断v是否大于w
     *
     * @param v
     * @param w
     * @return
     */
    private static Boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换i索引和j索引的值
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
