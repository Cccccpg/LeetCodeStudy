package Offer;

import Utils.ListNode;

import java.util.Stack;

public class Offer06 {

    /**
     * 从尾到头打印链表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }
}
