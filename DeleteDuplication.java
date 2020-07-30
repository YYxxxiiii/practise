package leetcode;

/**
 * nowcoder
 * 删除链表中重复结点
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 */

/**
 * 重复的点后面那个点肯定也是一样的
 * 找到重复的范围,跳过他,继续遍历
 * 不重复的数字加入新的链表
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) { //先判断是否和后一个结点重复
                while (cur.next != null && cur.val == cur.next.val){ //找到 相同结点的末尾
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }


    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;

        while (cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                newTail.next = cur; //两个代码的差别在这
                newTail = cur;
                cur = cur.next;
            }
        }
        newTail.next = null; //两个代码的差别在这
        return newHead.next;
    }
}
