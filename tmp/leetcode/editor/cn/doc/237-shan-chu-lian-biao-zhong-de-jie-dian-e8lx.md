### 解题思路
将待删节点`node`的值更新为其后驱节点的值，再将其后驱节点删去。最终结果相当于删除了题目要求的待删节点`node`。

### 复杂度分析
- 时间复杂度：O(1)。
- 空间复杂度：O(1)。

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```