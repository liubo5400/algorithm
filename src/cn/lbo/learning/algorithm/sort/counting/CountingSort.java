package cn.lbo.learning.algorithm.sort.counting;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.counting
 * @ClassName: CountingSort
 * @Description: 计数排序
 * 基本思想是对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数，利用这个信息将元素x直接存放到输出序列的正确位置上。
 * @Version 1.0
 */
public class CountingSort {

    /**
     * 首先创建一个计数数组count，并初始化为0。
     * 然后遍历输入数组array，对于每个元素x，将count[x]的值加1。
     * 接下来，使用一个循环，将count数组中的每个元素累加前面所有元素的值，这样count[i]就表示输入数组中小于等于i的元素个数。
     * 接着，创建一个临时数组sortedArray，并从输入数组的末尾开始遍历，将每个元素x放到sortedArray数组的正确位置上，即sortedArray[count[x]-1]。
     * 最后，我们将sortedArray数组中的元素复制回输入数组array中，完成排序。
     */
    public static void countingSort(int[] array, int maxVal) {
        int[] count = new int[maxVal + 1];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= maxVal; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted array back to the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = sortedArray[i];
        }
    }
}
