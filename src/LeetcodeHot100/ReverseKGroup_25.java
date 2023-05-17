package LeetcodeHot100;

import Utils.ListNode;

public class ReverseKGroup_25 {

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     *
     * 先统计链表长度，然后除以k，判断需要反转多少段
     * 然后再根据k-1可知，每一段中需要循环多少次
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = head, q = head.next;
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        head = pre;
        for(int i = 0; i < length / k; i++){
            if(i > 0){
                pre = p;
                p = q;
                q = q.next;
            }
            for(int j = 0; j < k - 1; j++){
                p.next = q.next;
                q.next = pre.next;
                pre.next = q;
                q = p.next;
            }
        }
        return head.next;
    }
}
