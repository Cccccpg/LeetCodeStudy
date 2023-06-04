package LeetcodeHot100;

class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        // 迭代法
        if (head == null){
            return null;
        }
        ListNode p = head, q = null;
        while (p != null){
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }
        return q;

        // 递归法
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
    }
}
