package Linklist_Stack_Queue;


import java.util.Stack;

public class ImplementQueueUsingStack_232 {

    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     *
     * 实现 MyQueue 类：
     *
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/implement-queue-using-stacks
     */

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public void MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        moveStackIn();
        return stackOut.pop();
    }


    public int peek() {
        moveStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void moveStackIn() {
        if(stackIn.isEmpty()){
            return;
        }else{
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
