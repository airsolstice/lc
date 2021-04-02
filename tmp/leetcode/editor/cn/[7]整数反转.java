//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2662 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String sx = x + "";
        char[] csx = sx.toCharArray();
        for (int i = 0; i < csx.length/ 2; i++) {
            char t = csx[i];
            csx[i] = csx[csx.length - 1 -i];
            csx[csx.length - 1 -i]= t;
        }

        String reverse;
        Long res;
        if(sx.startsWith("-")){
            reverse = String.valueOf(csx).substring(0, csx.length - 1);
            res =  -1* Long.parseLong(reverse);
        } else {
            reverse = String.valueOf(csx);
            res = Long.parseLong(reverse);
        }

        if(res <= Integer.MIN_VALUE || res >= Integer.MAX_VALUE){
            return 0;
        } else {
            return res.intValue();
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
