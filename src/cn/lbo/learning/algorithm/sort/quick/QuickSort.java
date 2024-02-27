package cn.lbo.learning.algorithm.sort.quick;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.quick
 * @ClassName: QuickSort
 * @Description: 快速排序 （不稳定排序）
 * @原理：
 * 1、选定一个分界值，将数组分为左右两个部分
 * 2、将大于分界值的所有元素放到数组右边，将小于分界值的所有元素放到数组左边
 * 3、分别对左右两边继续排序，再次取分界值，进行比较拆分
 * 4、重复上述操作，直到全部排序完成
 * @Version 1.0
 */
public class QuickSort {

    /**
     * 对数组a进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int low = 0;
        int height = a.length - 1;
        sort(a, low, height);
    }

    /**
     * 对数组a中，索引low到索引height之间的元素进行排序
     *
     * @param a
     * @param low
     * @param height
     */
    private static void sort(Comparable[] a, int low, int height) {
        //安全性校验
        if (low >= height) {
            return;
        }
        //需要对数组a中，从low索引到height索引的所有元素进行分组，分为（左子组、右子组）
        int partition = partition(a, low, height);//返回分界值索引
        //让左子组有序
        sort(a, low, partition - 1);
        //让右子组有序
        sort(a, partition + 1, height);
    }

    /**
     * 对数组a进行分组，并返回分界值索引
     *
     * @param a
     * @param low
     * @param height
     * @return
     */
    private static int partition(Comparable[] a, int low, int height) {
        //确定分界值
        Comparable key = a[low];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = low;
        int right = height + 1;
        //切分
        while (true) {
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key, a[--right])) {
                if (right == low) {
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left], key)) {
                if (left == height) {
                    break;
                }
            }
            //判断left >= right，则扫描结束，推出循环
            if (left >= right) {
                break;
            } else { // 未扫描结束，交换元素
                exch(a, left, right);
            }
        }
        //交换分界值
        exch(a, low, right);
        return right;
    }


    /**
     * 判断v是否小于w
     *
     * @param v
     * @param w
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中，i索引和j索引的值
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
