//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 765 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {


        if(needle.equals("") && haystack.equals("")) {
            return 0;
        }


        if(haystack.equals("")){
            return -1;
        }

        if(haystack.equals(needle) || needle.equals("")){
            return 0;
        }

        int p1 = 0, p2 = 0, p3 = 0;
        char[] ha = haystack.toCharArray();
        char[] na = needle.toCharArray();
        while (p2 < haystack.length()) {
            if(p3 == na.length){
                break;
            }
            if(ha[p2] == na[p3]){
                p1 = p2;
                p3 ++;
            } else {
                p3 = 0;
            }
            p2 ++;
        }

        return p3 == na.length? p1 - na.length + 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
