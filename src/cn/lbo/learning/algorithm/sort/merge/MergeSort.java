package cn.lbo.learning.algorithm.sort.merge;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.merge
 * @ClassName: MergeSort
 * @Description: 归并排序
 * <p>
 * 一、定义：
 * 归并排序，是创建在归并操作上的一种有效的排序算法。算法是采用分治法（Divide and Conquer）的一个非常典型的应用，
 * 且各层分治递归可以同时进行。归并排序思路简单，速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 * <p>
 * 二、基本思想：
 * 归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
 * （1）分解（Divide）：将n个元素分成个含n/2个元素的子序列。
 * （2）解决（Conquer）：用合并排序法对两个子序列递归的排序。
 * （3）合并（Combine）：合并两个已排序的子序列已得到排序结果。
 * <p>
 * 三、实现逻辑
 * 1、迭代法
 * ① 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * ② 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * ③ 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * ④ 重复步骤③直到某一指针到达序列尾
 * ⑤ 将另一序列剩下的所有元素直接复制到合并序列尾
 * <p>
 * 2、递归法
 * ① 将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
 * ② 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
 * ③ 重复步骤②，直到所有元素排序完毕
 * <p>
 * 四、时间复杂度
 * 平均时间复杂度：O(nlogn)  （不管元素在什么情况下都要做这些步骤，所以花销的时间是不变的，所以该算法的最优时间复杂度和最差时间复杂度及平均时间复杂度都是一样的为：O( nlogn )）
 * 最佳时间复杂度：O(n)
 * 最差时间复杂度：O(nlogn)
 * 空间复杂度：O(n)  （归并的空间复杂度就是那个临时的数组和递归时压入栈的数据占用的空间：n + logn；所以空间复杂度为: O(n)）
 * 排序方式：In-place
 * 稳定性：稳定  （归并排序算法中，归并最后到底都是相邻元素之间的比较交换，并不会发生相同元素的相对位置发生变化，故是稳定性算法）
 * @Version 1.0
 */
public class MergeSort {

    //归并排序所需的辅助数组
    private static Comparable[] assist;

    /**
     * 对数组a进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        //1、初始化辅助数组
        assist = new Comparable[a.length];
        //2、定义low和height，记录数组中最小索引和最大索引
        int low = 0;
        int height = a.length - 1;
        //3、调用sort方法对a数组进行排序
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
        //对low到height之间的数据分为两个组
        int mid = low + (height - low) / 2;
        //分别对每组数据进行排序
        sort(a, low, mid);
        sort(a, mid + 1, height);
        //把两个组进行归并
        merge(a, low, mid, height);
    }

    /**
     * 把数组a中的两个子组的数据合并成一个有序的大组（从索引low到索引height）
     * 从索引low到索引mid为一个子组
     * 从索引mid+1到索引height为一个子组
     *
     * @param a
     * @param low
     * @param mid
     * @param height
     */
    private static void merge(Comparable[] a, int low, int mid, int height) {
        //定义三个指针
        int i = low;
        int p1 = low;
        int p2 = mid + 1;
        //遍历，移动p1,p2指针，比较对应索引处的值，找出小的那个放到辅助数组中
        while (p1 <= mid && p2 <= height) {
            //比较对应索引处的值
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果p1指针没有走完，那么顺序移动p1指针，将对应元素放到辅助数组当中
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        //遍历，如果p2指针没有走完，那么顺序移动p2指针，将对应元素放到辅助数组当中
        while (p2 <= height) {
            assist[i++] = a[p2++];
        }
        //把辅助数组中的元素，拷贝到原数组
        for (int index = low; index <= height; index++) {
            a[index] = assist[index];
        }
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

}
