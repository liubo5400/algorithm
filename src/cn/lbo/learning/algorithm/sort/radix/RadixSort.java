package cn.lbo.learning.algorithm.sort.radix;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.radix
 * @ClassName: RadixSort
 * @Description: 基数排序
 *
 * 时间复杂度为O(n)
 * @Version 1.0
 */
public class RadixSort {

    /**
     * 在基数排序中，先从个位开始，对数组进行排序，然后再从十位、百位等高位开始，逐次进行排序。
     * @param arr
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 找到数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // 从个位开始，对数组进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 使用计数排序作为子排序算法
     *
     * 先统计每个数字出现的次数，然后计算每个数字在输出数组中的位置，最后将数字按照计算得到的位置放入输出数组中。
     *
     * @param arr
     * @param exp
     */
    private static void countingSort(int[] arr, int exp) {
        int[] count = new int[10];
        int[] output = new int[arr.length];

        // 统计每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 计算每个数字在输出数组中的位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 将数字按照计算得到的位置放入输出数组中
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将输出数组复制到原数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
