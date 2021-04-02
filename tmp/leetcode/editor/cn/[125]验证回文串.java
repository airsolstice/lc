//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = 0;
        char[] sa = s.toCharArray();

        while (p2 < sa.length) {
            if(sa[p2] >= 'A' && sa [p2]<= 'Z'){
                sa[p1] = (char) (sa[p2] + 32);
                p1++;
            } else if(sa[p2] >= 'a' && sa [p2]<= 'z'){
                sa[p1] = sa[p2];
                p1++;
            }
            p2++;
        }

        if(p1 == 0){
            return true;
        }

        for (int i = 0; i < p1; i++) {
            if(sa[i] != sa[p1 - 1 -i]){
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
