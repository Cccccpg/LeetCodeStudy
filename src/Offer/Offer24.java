package Offer;

import Utils.ListNode;

public class Offer24 {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = head, q = null;
        ListNode newHead = null;
        while(p != null){
            q = p.next;
            p.next = newHead;
            newHead = p;
            p = q;
        }
        return newHead;
    }
}
