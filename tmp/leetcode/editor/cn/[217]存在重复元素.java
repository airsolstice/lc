//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 376 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int p1 = 0;
        int p2 = 1;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (p2 >= nums.length) {
                return false;
            }
            if (nums[p1] == nums[p2]) {
                return true;
            }

            p1++;
            p2++;
        }


        return false;
    }


    private void quickSort(int[] nums, int l, int h) {
        if(l > h){
            return;
        }

        int p = nums[l];
        int i = l, j = h;

        while (i < j) {
            while (nums[j] >= p && i < j) {
                j--;
            }

            while (nums[i] <= p && i < j) {
                i++;
            }

            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        nums[l] = nums[i];
        nums[i] = p;

        quickSort(nums, l, j -1);
        quickSort(nums, j + 1, h);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
