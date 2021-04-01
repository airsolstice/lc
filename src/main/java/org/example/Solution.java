package org.example;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] cube = new String[][]{
                {"5","3",".",".","7",".",".",".","."},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
        };


//        solution.moveZeroes(new int[]{0,1,0,3,12});
//        solution.moveZeroes(new int[]{1,0});
//        System.out.println(Arrays.toString(solution.twoSum1(new int[]{1, 3, 4, 4}, 8)));
//        System.out.println(solution.binarySearch(new int[]{1, 2, 7,11, 15}, 1, 0, 5));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> r = new HashSet<>();
            Set<Character> c = new HashSet<>();
            Set<Character> m = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(!".".equals(board[i][j] + "") &&r.contains(board[i][j])){
                    return false;
                } else {
                    r.add(board[i][j]);
                }

                if(!".".equals(board[j][i] + "") && c.contains(board[j][i])){
                    return false;
                } else {
                    c.add(board[j][i]);
                }

                if(i< 6 && j < 6){
                    if(!".".equals(board[j][i] + "") && m.contains(board[i][j])){
                        return false;
                    } else {
                        m.add(board[i][j]);
                    }

                    if(!".".equals(board[i+2][j] + "") && m.contains(board[i +1][j])){
                        return false;
                    } else {
                        m.add(board[i+1][j]);
                    }
                    if(!".".equals(board[i+2][j] + "") && m.contains(board[i +2][j])){
                        return false;
                    } else {
                        m.add(board[i+2][j]);
                    }
                    if(!".".equals(board[i][j+1] + "") && m.contains(board[i][j + 1])){
                        return false;
                    } else {
                        m.add(board[i][j+1]);
                    }
                    if(!".".equals(board[i][j +2] + "") && m.contains(board[i][j + 2])){
                        return false;
                    } else {
                        m.add(board[i][j+2]);
                    }
                    if(!".".equals(board[i+1][j +1] + "") && m.contains(board[i + 1][j + 1])){
                        return false;
                    } else {
                        m.add(board[i+1][j+1]);
                    }
                    if(!".".equals(board[i+1][j +2] + "") && m.contains(board[i + 1][j + 2])){
                        return false;
                    } else {
                        m.add(board[i+1][j+2]);
                    }
                    if(!".".equals(board[i+2][j +1] + "") && m.contains(board[i + 2][j + 1])){
                        return false;
                    } else {
                        m.add(board[i+2][j+1]);
                    }
                    if(!".".equals(board[i+2][j +2] + "") && m.contains(board[i + 2][j + 2])){
                        return false;
                    } else {
                        m.add(board[i+2][j+2]);
                    }
                }

            }
        }

        return false;

    }



    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int v1 = numbers[i];
            int v2 = target - v1;

            int idx = binarySearch(numbers, v2, 0, numbers.length);
            if(idx >= 0){
                if(i == idx) {
                    idx ++;
                }
                return new int[]{i + 1, idx + 1};
            }
        }


        return new int[]{};
    }

    private int binarySearch(int[] numbers, int v, int l, int r) {

        if(l >= r){
            return -1;
        }

        int mid = (l + r) / 2;
        if(numbers[mid] == v){
            return mid;
        } else if(numbers[mid] > v){
           return binarySearch(numbers, v, l, mid);
        } else {
            return binarySearch(numbers, v, mid + 1, r);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int v = target - numbers[i];
            if(map.containsKey(v)){
                return new int[]{map.get(v), i};
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[]{};
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
