package leetcode;

/*
206. 反转链表
反转一个单链表。

        示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
 */

/**
 * cur:代表当前需要反转的节点
 * prev:代表前驱
 * newHead :新链表的头节点
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) { // 空链表情况
            return null;
        }
        if (head.next == null) { // 链表中只有一个元素的时候
            return head;
        }
        ListNode newHead = null; //新链表的头节点
        ListNode cur = head; //当前要反转的节点
        ListNode prev = null; //这是自己创建的一个新的节点,为cur的前驱节点
        while (cur != null) {
            ListNode curNext = cur.next; //记录位置
            if (cur.next == null) { //走到了链表的末尾
                newHead = cur;
            }
            cur.next = prev; //链表箭头换向
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;

        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = prev; //注意此处的cur.next可不能写成next,因为现在是要此链表逆过去,next是存放cur的下一个节点的
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    /**
     * 递归法
     * 递归的意思：我子节点下的所有节点都已经反转好了，
     * 现在就剩我和我的子节点 没有完成最后的反转了，
     * 所以反转一下我和我的子节点。
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
