package org.example;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome("P0"));
//        solution.isAnagram("car", "rac");
//        System.out.println(solution.firstUniqChar("loveleetcode"));
//        System.out.println(solution.reverse(-123));


        char[][] cube = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        int[][] martix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        solution.rotate(martix);
//        System.out.println(solution.isValidSudoku(cube));
//        solution.moveZeroes(new int[]{0,1,0,3,12});
//        solution.moveZeroes(new int[]{1,0});
//        System.out.println(Arrays.toString(solution.twoSum1(new int[]{1, 3, 4, 4}, 8)));
//        System.out.println(solution.binarySearch(new int[]{1, 2, 7,11, 15}, 1, 0, 5));
    }

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

    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        Arrays.sort(sa);
        Arrays.sort(ta);
        return String.valueOf(sa).equals(String.valueOf(ta));
    }

    public int firstUniqChar(String s) {

        int p = 999;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (Integer value : map.values()) {
            if (value > -1) {
                p = p > value ? value : p;
            }
        }

        return p == 999 ? -1 : p;
    }


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            System.out.println("rev: " + rev);
            System.out.println("pop: " + pop);
            System.out.println("x: " + x);

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = t;
        }
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int t1 = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                int t2 = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = t1;
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = t2;
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rol = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (rol[i][num] == 1) {
                    return false;
                }
                if (col[j][num] == 1) {
                    return false;
                }
                if (box[(i / 3) * 3 + j / 3][num] == 1) {
                    return false;
                }
                rol[i][num] = 1;
                col[j][num] = 1;
                box[(i / 3) * 3 + j / 3][num] = 1;
            }
        }
        return true;

    }


    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int v1 = numbers[i];
            int v2 = target - v1;

            int idx = binarySearch(numbers, v2, 0, numbers.length);
            if (idx >= 0) {
                if (i == idx) {
                    idx++;
                }
                return new int[]{i + 1, idx + 1};
            }
        }


        return new int[]{};
    }

    private int binarySearch(int[] numbers, int v, int l, int r) {

        if (l >= r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if (numbers[mid] == v) {
            return mid;
        } else if (numbers[mid] > v) {
            return binarySearch(numbers, v, l, mid);
        } else {
            return binarySearch(numbers, v, mid + 1, r);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int v = target - numbers[i];
            if (map.containsKey(v)) {
                return new int[]{map.get(v), i};
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[]{};
    }

    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 0;

        if (nums.length == 1) {
            return;
        }

        while (p2 < nums.length) {
            if (nums[p2] != 0) {
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }

        while (p1 < nums.length) {
            nums[p1] = 0;
            p1++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
