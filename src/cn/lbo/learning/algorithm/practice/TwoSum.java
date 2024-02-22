package cn.lbo.learning.algorithm.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author bjliubo
 * @Date 2024/1/2 17:49
 * @PackageName:cn.lbo.learning.algorithm.practice
 * @ClassName: TwoSum
 * @Description: TODO
 * @Version 1.0
 */
public class TwoSum {

    /**
     给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     你可以按任意顺序返回答案。

     示例 1：
     输入：nums = [2,7,11,15], target = 9
     输出：[0,1]
     解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

     示例 2：
     输入：nums = [3,2,4], target = 6
     输出：[1,2]

     示例 3：
     输入：nums = [3,3], target = 6
     输出：[0,1]
     */

    /**
     * 方法一：暴力法
     * <p>
     * 时间复杂度：O(N2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_one(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 方法二：哈希表
     * <p>
     * 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * 空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_two(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6, 8, 9};
        int target = 9;
        int[] result = new TwoSum().twoSum_one(nums, target);
        System.out.println(Arrays.toString(result));

        result = new TwoSum().twoSum_two(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
