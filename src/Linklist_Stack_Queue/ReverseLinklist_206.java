package Linklist_Stack_Queue;

import Utils.ListNode;

public class ReverseLinklist_206 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * https://leetcode.cn/problems/reverse-linked-list/
     *
     * 就是创建两个节点
     * 1 -> 2 -> 3 -> 4 -> 5
     * q
     *
     * 1 -> p
     * q
     *
     * 2 -> 3 -> 4 -> 5
     * q
     *
     * 1
     * p
     * @param head
     * @return
     */

    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;

        while (q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }
}
