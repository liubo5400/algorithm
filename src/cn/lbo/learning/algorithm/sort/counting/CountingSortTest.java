package cn.lbo.learning.algorithm.sort.counting;

/**
 * @Author bjliubo
 * @Date 2023/3/27 14:46
 * @PackageName:cn.lbo.learning.algorithm.sort.counting
 * @ClassName: CountingSortTest
 * @Description: TODO
 * @Version 1.0
 */
public class CountingSortTest {

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 0, 2, 3, 0, 3};
        int maxVal = 5;
        CountingSort.countingSort(array, maxVal);

        // Print the sorted array
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
