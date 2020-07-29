package leetcode;

/*203.移除链表元素

删除链表中等于给定值 val 的所有节点。

        示例:
        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //先不考虑头结点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) { //cur.val里的这个val是内部类ListNode里的那个数据,后面那个val是要删除的数据
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //头结点来了
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
