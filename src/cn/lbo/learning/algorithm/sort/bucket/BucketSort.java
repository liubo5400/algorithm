package cn.lbo.learning.algorithm.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.bucket
 * @ClassName: BucketSort
 * @Description: 桶排序
 *
 * 使用了一个List<List<Integer>>来存储桶，其中每个桶都是一个List<Integer>。
 * 首先，遍历整个数组，找到最小值和最大值，
 * 然后计算出桶的数量。
 * 接着，将每个元素分配到对应的桶中。
 * 最后，对每个桶进行排序，并将它们合并起来得到排序后的结果。
 * @Version 1.0
 */
public class BucketSort {

    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length <= 1) {
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            buckets.get(bucketIndex).add(arr[i]);
        }
        int currentIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            Collections.sort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                arr[currentIndex++] = bucket.get(j);
            }
        }
    }
}
