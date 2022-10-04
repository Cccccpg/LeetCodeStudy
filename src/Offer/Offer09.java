package Offer;

import java.util.Stack;

public class Offer09 {

    /**
     * 用两个栈实现队列功能
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public void CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }
}
