package Linklist_Stack_Queue;

import Utils.ListNode;

public class MergeTwoLists_21 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * https://leetcode.cn/problems/merge-two-sorted-lists/
     *
     * 方法一：暴力合并
     *
     * 方法二：递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //方法一：暴力合并
//        ListNode  newList = new ListNode(0);
//        ListNode  p = newList;
//        while (list1 != null && list2 != null){
//            if (list1.val < list2.val){
//                p.next = list1;
//                p = p.next;
//                list1 = list1.next;
//            }else {
//                p.next = list2;
//                p = p.next;
//                list2 = list2.next;
//            }
//
//        }
//        if (list1 == null){
//            p.next = list2;
//        }else {
//            p.next = list1;
//        }
//        return newList.next;

        //方法二：递归
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
