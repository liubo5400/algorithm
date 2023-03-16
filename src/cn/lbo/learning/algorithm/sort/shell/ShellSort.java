package cn.lbo.learning.algorithm.sort.shell;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:43
 * @PackageName:cn.lbo.learning.algorithm.sort.shell
 * @ClassName: ShellSort
 * @Description: 希尔排序
 * @原理： 1、选定一个增量h，按照增量h作为数据分组的依据，对数据进行分组
 * 2、对分好组的每一组数据进行插入排序
 * 3、减少增量h，最小减为1，重复第二步操作
 * @Version 1.0
 */
public class ShellSort {

    /**
     * 对a数组进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        //1、根据数组a的长度定好增长量
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //2、希尔排序
        while (h >= 1) {
            //排序
            //1、首先找到待插入元素
            for (int i = h; i < a.length - 1; i++) {
                //2、把待插入元素插入有序队列中
                for (int j = i; j >= h; j -= h) {
                    //待插入元素是a[j]，比较a[j]和a[j-h]
                    if (greater(a[j - h], a[j])) {
                        //交换元素
                        exch(a, j - h, j);
                    } else {
                        //待插入元素不需要交换，结束循环
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
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
