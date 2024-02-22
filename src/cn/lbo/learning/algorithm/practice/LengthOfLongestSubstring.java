package cn.lbo.learning.algorithm.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author bjliubo
 * @Date 2024/1/3 11:01
 * @PackageName:cn.lbo.learning.algorithm.practice
 * @ClassName: LengthOfLongestSubstring
 * @Description: TODO
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * <p>
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            set.add(String.valueOf(chars[i]));
            for (int j = i + 1; j < chars.length; j++) {
                if (set.contains(String.valueOf(chars[j]))) {
                    break;
                } else {
                    set.add(String.valueOf(chars[j]));
                }
            }
            if (set.size() > max) {
                max = set.size();
            }
            set.clear();
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        int start, end = 0, max = 0;
        for (start = 0; start < chars.length; start++) {
            if (chars.length - start <= max) {
                break;
            }
            if(start > 0) {
                set.remove(String.valueOf(chars[start - 1])); //删除
            }
            set.add(String.valueOf(chars[start]));
            if (end < start) {
                end = start;
            }
            while (end + 1 < chars.length && !set.contains(String.valueOf(chars[end + 1]))) {
                set.add(String.valueOf(chars[end + 1]));
                end++;
            }
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2("pwwkew"));
    }
}
