### 解题思路

本题目在于满足题目中所要求的三个不重复条件:

（1）九宫格内每一行的元素九个数字不存在重复。
（2）九宫格内的每一列的元素九个元素不存在重复
（3）九宫格内的每一个九宫格元素不能重复

算法流程:
（1）建立三个状态数组存储每一个元素在行，列，九宫格的存在与否。
（2）对目标数独数组进行遍历，如果为'.'，表示为空格符号，跳出本次循环，不用判断
（3）将字符型转换为整数型进行比较
（4）如果行，列，九宫格的三个状态数组中有一个为1，表示出现重复
（5）将遍历后的数组进行赋值'1'，表示已经遍历过了
（6）如果没有为'1'，表示为有效数独类型，返回true

### 代码

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rol = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num = board[i][j]-'0';
                if(rol[i][num]==1){
                    return false;
                }
                if(col[j][num]==1){
                    return false;
                }
                if(box[(i/3)*3+j/3][num]==1){
                    return false;
                }
                rol[i][num]=1;
                col[j][num]=1;
                box[(i/3)*3+j/3][num]=1;
            }
        }
        return true;
    }
}
```

运行截图：

![123.png](https://pic.leetcode-cn.com/1614684599-yOhKeW-123.png)
