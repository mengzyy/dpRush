package com.company;

/**
 * @program: dpRush
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-29 12:15
 **/

import sun.nio.cs.ext.MacArabic;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EditPath {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                int t = Integer.MAX_VALUE;
                int t2 = Integer.MAX_VALUE;
                if (a == b) {
                    t = dp[i - 1][j - 1];
                } else {
                    t2 = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
                dp[i][j] = Math.min(t, t2);
            }
        }
        return dp[n][m];

    }
}
