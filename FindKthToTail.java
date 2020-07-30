package leetcode;

/**
 *nowcoder
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

//链表长度减去k就是要走的步数,就可以知道倒数第k个结点的位置
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        int size = size(head);
        if (head == null) {
            return null;
        }
        if (k <= 0 || k > size) {
            return null;
        }
        int steps = size - k;
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
