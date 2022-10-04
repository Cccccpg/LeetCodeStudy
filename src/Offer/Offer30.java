package Offer;

import java.util.LinkedList;

public class Offer30 {

    /**
     * 一个包含min函数的栈
     */

    LinkedList<Integer> mainStack;
    LinkedList<Integer> minStack;

    /** initialize your data structure here. */
    public void MinStack() {
        mainStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        mainStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
