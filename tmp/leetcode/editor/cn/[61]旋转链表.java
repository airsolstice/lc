//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 533 👎 0


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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode n = head;
        ListNode ptr;
        while(true) {
            if(n.next == null){
                ptr = n;
                list.add(n);
                break;
            }
            list.add(n);
            n = n.next;
        }

        k = k % list.size();
        if(k == 0){
            return head;
        }

        int m = list.size() - k - 1;
        ListNode t = list.get(m);
        ListNode h = list.get(m + 1);
        t.next = null;

        ptr.next = head;

        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
