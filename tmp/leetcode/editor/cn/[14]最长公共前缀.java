//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1544 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int p = 0;

        if(strs.length == 0 || strs[0].length() == 0){
            return "";
        }

        char[] first = strs[0].toCharArray();

        for (int i = 0; i < first.length; i++) {
            char v = first[p];
            for (int j = 0; j < strs.length; j++) {
                if(p >= strs[j].length()){
                    return strs[j];
                }

                if(strs[j].charAt(p) != v){
                    return strs[j].substring(0, p);
                }
            }
            p++;
        }



        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
