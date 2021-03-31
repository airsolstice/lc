package org.example;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.moveZeroes(new int[]{0,1,0,3,12});
        solution.moveZeroes(new int[]{1,0});

    }


    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 0;

        if(nums.length == 1){
            return;
        }

        while (p2 < nums.length) {
            if(nums[p2] != 0){
                nums[p1] = nums[p2];
                p1++;
            }
            p2 ++;
        }

        while (p1 < nums.length) {
            nums[p1] = 0;
            p1++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
