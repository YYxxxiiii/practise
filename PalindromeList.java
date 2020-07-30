package leetcode;


/*
nowcoder
链表的回文结构
对于一个链表，请设计一个时间复杂度为O(n),
额外空间复杂度为O(1)的算法，判断其是否为回文结构。

    给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    测试样例：
    1->2->2->1
    返回：true
*/

/**
 * 1.找到链表中间的位置
 * 2.链表中间的位置后的链表逆置
 * 3.开始比较两个链表的值
 * 4.以B为判断条件,因为A中间结点那个位置是两个链表共用的,当B为null的时候就可以停下来了(尤其是偶数个的时候傲)
 */
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        //1.找到链表的中间
        int size = size(A);
        int steps = size / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        //2.逆置B这个链表
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {  //到了链尾,更新头节点的位置
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while (B != null) {
            if (A.val != B.val) {
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;

    }
    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
}
