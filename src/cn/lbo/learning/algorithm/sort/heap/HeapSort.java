package cn.lbo.learning.algorithm.sort.heap;

/**
 * @Author bjliubo
 * @Date 2023/3/9 9:42
 * @PackageName:cn.lbo.learning.algorithm.sort.heap
 * @ClassName: HeapSort
 * @Description: 堆排序 （不稳定排序）
 * 基本思路是将输入数据构建成一个堆，然后依次取出堆顶元素并将其放到输出数组的末尾，最终得到一个有序的数组。
 * 时间复杂度为O(nlogn)
 * @Version 1.0
 */
public class HeapSort {

    /**
     * 首先定义一个heapSort方法，用于对输入数组进行堆排序。
     * 在堆排序之前，我们需要将输入数组构建成一个最大堆，这里我们定义了一个buildMaxHeap方法来完成这个任务。
     * 在buildMaxHeap方法中，从倒数第二层开始，依次对每个非叶子节点调用maxHeapify方法，将其与其子节点进行比较，如果有必要就交换位置，
     * 然后递归调用maxHeapify方法，以保证子树仍然满足最大堆的性质。
     *
     * 在堆排序中，首先将堆顶元素与最后一个元素交换位置，
     * 然后将堆的大小减1，再对堆顶元素进行maxHeapify操作，以保证其满足最大堆的性质。
     * 重复这个过程直到堆的大小为1，此时数组就已经排序完成了。
     */
    public static void heapSort(int[] array) {
        // Build max heap
        buildMaxHeap(array);

        // Heap sort
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            maxHeapify(array, 0, i);
        }
    }

    /**
     * 构建最大堆
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        int heapSize = array.length;

        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    private static void maxHeapify(int[] array, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            maxHeapify(array, largest, heapSize);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
