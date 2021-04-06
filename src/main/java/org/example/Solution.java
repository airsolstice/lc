package org.example;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.strStr("mississippi", "issip"));
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        head = solution.reverseList(head);
        System.out.println();

    }

    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode n = reverseList(head.next);
        System.out.println(n.val);
        head.next = null;
        n.next = head;
        
        return n.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1, p2, p3;
        p1 = head;
        p2 = head;
        p3 = null;

        for (int i = 0; i < n - 1; i++) {
            if(p2 == null){
                return null;
            }
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p3 = p1;
            p1 = p1.next;
        }


        if(p1.next == null){
            if(p3 != null){
                p3.next = null;
                return head;
            } else {
                return null;
            }
        }

        p1.val = p1.next.val;
        p1.next = p1.next.next;

        return head;
    }

    public String longestCommonPrefix(String[] strs) {
        int p = 0;

        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }

        char[] first = strs[0].toCharArray();

        for (int i = 0; i < first.length; i++) {
            char v = first[p];
            for (int j = 0; j < strs.length; j++) {
                if (p >= strs[j].length()) {
                    return strs[j];
                }

                if (strs[j].charAt(p) != v) {
                    return strs[j].substring(0, p);
                }
            }
            p++;
        }


        return strs[0];

    }

    public String countAndSay(int n) {

        int i = 1;
        String res = "1";
        String tmp = "";
        while (i++ < n) {
            char[] arr = res.toCharArray();
            res = "";
            int p1 = 0, p2 = 0;

            while (p2 <= arr.length) {
                if (p2 == arr.length) {
                    res += (p2 - p1) + "" + arr[p1];
                    break;
                }
                if (arr[p1] != arr[p2]) {
                    int len = p2 - p1;
                    res += len + "" + arr[p1];
                    p1 = p2;
                }
                p2++;
            }
            System.out.println(res);

        }


        return res;
    }

    public int strStr(String haystack, String needle) {

        if (needle.equals("") && haystack.equals("")) {
            return -1;
        }


        if (haystack.equals("")) {
            return -1;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        int p1 = 0, p2 = 0, p3 = 0;
        char[] ha = haystack.toCharArray();
        char[] na = needle.toCharArray();
        while (p2 < haystack.length()) {
            if (p3 == na.length - 1) {
                break;
            }
            if (ha[p2] == na[p3]) {
                p1 = p2;
                p3++;

            } else {
                p3 = 0;
                p2 = p1;
            }
            p2++;

        }

        return p3 == na.length ? p1 - na.length + 1 : -1;
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int sign = s.startsWith("-") ? -1 : 1;

        char[] sa = s.toCharArray();
        Long res = 0L;
        for (int i = sign == 1 ? 0 : 1; i < sa.length; i++) {
            int digit = sa[i] - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
        }

        return sign * res.intValue();
    }

    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = 0;
        char[] sa = s.toCharArray();

        while (p2 < sa.length) {
            if (sa[p2] >= 'A' && sa[p2] <= 'Z') {
                sa[p1] = (char) (sa[p2] + 32);
                p1++;
            } else if (sa[p2] >= 'a' && sa[p2] <= 'z') {
                sa[p1] = sa[p2];
                p1++;
            }
            p2++;
        }

        if (p1 == 0) {
            return true;
        }

        for (int i = 0; i < p1; i++) {
            if (sa[i] != sa[p1 - 1 - i]) {
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
