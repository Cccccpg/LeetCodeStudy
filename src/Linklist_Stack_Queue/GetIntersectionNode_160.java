package Linklist_Stack_Queue;

import Utils.ListNode;

public class GetIntersectionNode_160 {

    /**
     * 请你找出并返回两个单链表相交的起始节点。
     *
     * 输入：listA = [1,9,1,2,4], listB = [3,2,4]
     * 输出：Intersected at '2'
     *
     * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
     *
     * 设两个指针，分别指向headA和headB，一起向后移动
     * 谁先移到该链表的末尾，就移动的另一个链表的开头
     * 一直循环到 pA == pB，说明该节点是两链表相交的节点
     *
     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            //向后移动，到了链表结尾就移动到另一个链表开头
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }
}
