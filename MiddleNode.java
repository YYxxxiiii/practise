package leetcode;


/**
 * 876. 链表的中间结点
 * 返回非空链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */


public class MiddleNode {
    /**
     * 方法一:
     * 快慢指针法
     * 这个方法只遍历了一次链表
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 方法二:
     * 链表长度除以2
     * 那个长度就是中间结点所在位置
     */
    public ListNode middleNode2(ListNode head) {
        int size = size(head);
        int steps = size / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
}
