package Linklist_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_225 {

    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     *
     * 实现 MyStack 类：
     *
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/implement-stack-using-queues
     */

    private Queue<Integer> queueMain;
    private Queue<Integer> queueBackup;

    public void MyStack() {
        queueMain = new LinkedList<>();
        queueBackup = new LinkedList<>();
    }

    public void push(int x) {
       queueBackup.offer(x);
       while(!queueMain.isEmpty()){
           queueBackup.offer(queueMain.poll());
       }
       Queue<Integer> queueTemp = queueMain;
       queueMain = queueBackup;
       queueBackup = queueTemp;
    }

    public int pop() {
        return queueMain.poll();
    }

    public int top() {
        return queueMain.peek();
    }

    public boolean empty() {
        return queueMain.isEmpty();
    }

}
