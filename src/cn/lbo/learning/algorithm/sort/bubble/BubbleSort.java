package cn.lbo.learning.algorithm.sort.bubble;

import java.util.Arrays;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.bubble
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @原理：
 * 1、比较相邻两个元素，如果前一个元素比后一个元素大，则交换位置。
 * 2、对每一对相邻元素做同样的操作，最终最右侧的元素就是最大元素。
 * @时间复杂度： O(N ^ 2)
 * @Version 1.0
 */
public class BubbleSort {

    /**
     * 对a数组进行排序
     * 每次遍历都对比相邻的两个元素，把最大值放在最右边
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) { // 每遍历一次，参与比较的元素减少一个
            for (int j = 0; j < i; j++) {        // 依次比较相邻的两个元素的值
                if (greater(a[j], a[j + 1])) {   // 如果j 大于 j+1
                    exch(a, j, j + 1);        // 交换两个索引的值
                }
                System.out.print(i + " " + j +"  ");
                System.out.println(Arrays.toString(a));
            }
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
