package cn.lbo.learning.algorithm.sort.bucket;

import java.util.Arrays;

/**
 * @Author bjliubo
 * @Date 2023/3/27 14:38
 * @PackageName:cn.lbo.learning.algorithm.sort.bucket
 * @ClassName: BucketSortTest
 * @Description: TODO
 * @Version 1.0
 */
public class BucketSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 6, 1, 9, 5, 7, 8, 4};
        BucketSort.bucketSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
