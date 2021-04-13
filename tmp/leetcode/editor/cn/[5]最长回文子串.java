//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3486 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = true;
        }

        int mi = 0;
        int mj = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j >= i || j + 1 == arr.length){
                    continue;
                }

                dp[j][i] = arr[i] == arr[j] && (i -j == 1 || dp[j + 1][i -1]);
                if(dp[j][i] && i -j > mi - mj){
                    mi = i;
                    mj = j;
                }
            }
        }



        return s.substring(mj, mi +1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
