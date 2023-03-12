package cn.lbo.learning.algorithm.sort.insertion;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.insertion
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @原理：1、把所有元素分为两组，已排序和未排序的。 2、找到未排序的第一个元素，向已排序的组中插入。
 * 3、倒序遍历已排序的元素，依次和待插入元素比较，直到找到一个元素小于等于待插入元素，那么把待插入元素放到此为止，其他元素后移一位。
 * @Version 1.0
 */
public class InsertionSort {

    /**
     * 对a数组进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {//待排序元素
            for (int j = i; j > 0; j--) {//倒序取已排序元素
                if (greater(a[j - 1], a[j])) {//判断前一个元素的值大于目标元素
                    exch(a, j - 1, j);//交换前一元素和目标元素位置
                } else {
                    break;
                }
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
