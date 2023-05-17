package LeetcodeHot100;

import Utils.ListNode;

public class IsPalindrome_234 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * 要求：用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
     *
     * 这道题如果没有要求，很好做，直接转换成list，然后按照正常判断回文的方法判断就行
     * 但是这题要求时间复杂度和空间复杂度
     * 所以可以使用快慢指针，先找到整个链表的后半部分
     * 然后反转后半部分链表
     * 再进行对比，判断是否为回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null){
            if(head.val == slow.val){
                head = head.next;
                slow = slow.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
