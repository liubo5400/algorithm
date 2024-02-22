package cn.lbo.learning.algorithm.base;

/**
 * @Author bjliubo
 * @Date 2024/2/22 15:32
 * @PackageName:cn.lbo.learning.algorithm.base
 * @ClassName: KMP
 * @Description: KMP算法是一种改进的字符串匹配算法。KMP算法的时间复杂度 O(m + n)
 * 参考文献：https://cloud.tencent.com/developer/article/2235837
 * @Version 1.0
 */
public class KMP {

    public void calNext(char[] strs, int[] next, int len) {
        next[0] = -1; //next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q < len; q++) {
            while (k > -1 && strs[k + 1] != strs[q]) {//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
                k = next[k];//往前回溯
            }
            if (strs[k + 1] == strs[q]) {//如果相同，k++
                k++;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
        }
    }


    public int kmp(char[] str, int slen, char[] ptr, int plen) {
        int[] next = new int[plen];
        calNext(ptr, next, plen);//计算next数组
        int k = -1;
        for (int i = 0; i < slen; i++) {
            while (k > -1 && ptr[k + 1] != str[i]) {//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
                k = next[k];//往前回溯
            }
            if (ptr[k + 1] == str[i]) {
                k++;
            }
            if (k == plen - 1) {//说明k移动到ptr的最末端
                return i - plen + 1;//返回相应的位置
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmpTest = new KMP();
        String str = "bacbababadababacambabacaddababacasdsd";
        String ptr = "ababaca";
        char[] strs = str.toCharArray();
        char[] ptrs = ptr.toCharArray();
        int slen = strs.length;
        int plen = ptrs.length;
        int result = kmpTest.kmp(strs, slen, ptrs, plen);
        System.out.println(result);
    }

}
