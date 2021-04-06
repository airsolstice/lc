//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)
