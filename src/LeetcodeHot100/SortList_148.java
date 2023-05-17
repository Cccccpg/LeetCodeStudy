package LeetcodeHot100;

import Utils.ListNode;

public class SortList_148 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next.next, slow = head;
        ListNode leftPart, rightPart;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //对右边部分进行归并排序
        rightPart = mergeSort(slow.next);
        slow.next = null;   //将原链表从中间断开，排序结束
        leftPart = mergeSort(head);
        //对左边部分进行归并排序
        return mergeList(leftPart, rightPart);
    }

    //合并链表
    public ListNode mergeList(ListNode left, ListNode right){
        ListNode tempHead = new ListNode(0);
        ListNode p = tempHead;
        while(left != null && right != null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if(left == null){
            p.next = right;
        }else{
            p.next = left;
        }
        return tempHead.next;
    }
}
