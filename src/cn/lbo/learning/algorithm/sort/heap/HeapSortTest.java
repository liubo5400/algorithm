package cn.lbo.learning.algorithm.sort.heap;

/**
 * @Author bjliubo
 * @Date 2023/3/27 14:56
 * @PackageName:cn.lbo.learning.algorithm.sort.heap
 * @ClassName: HeapSortTest
 * @Description: TODO
 * @Version 1.0
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 0, 2, 3, 0, 3};
        HeapSort.heapSort(array);

        // Print the sorted array
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
