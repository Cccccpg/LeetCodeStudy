package LeetcodeHot100;

import Utils.ListNode;

import java.util.LinkedHashMap;

public class SwapPairs_24 {

    /**
     *给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * 用三个指针，交换节点就行
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head, p = head;
        while(slow != null){
            fast = slow.next;
            if(fast == null){
                return head;
            }
            if(slow == head){
                slow.next = fast.next;
                fast.next = slow;
                head = fast;
            }else{
                slow.next = fast.next;
                fast.next = slow;
                p.next = fast;
            }
            p = slow;
            slow = slow.next;
        }
        return head;
    }
}
