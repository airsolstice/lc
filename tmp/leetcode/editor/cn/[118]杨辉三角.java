//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
// [1],
// [1,1],
// [1,2,1],
// [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 476 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {

        Integer[][] dp = new Integer[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if(i < j){
                    continue;
                }

                if(j == 0 || i == j){
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i -1][j -1] + dp[i - 1][j];

            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                row.add(dp[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
