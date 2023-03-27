package cn.lbo.learning.algorithm.sort.radix;

import java.util.Arrays;

/**
 * @Author bjliubo
 * @Date 2023/3/27 15:03
 * @PackageName:cn.lbo.learning.algorithm.sort.radix
 * @ClassName: RadixSortTest
 * @Description: TODO
 * @Version 1.0
 */
public class RadixSortTest {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));  // [2, 24, 45, 66, 75, 90, 170, 802]
    }
}
