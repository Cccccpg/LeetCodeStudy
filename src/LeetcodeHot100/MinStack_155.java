package LeetcodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_155 {
    /**
     * 用双端队列来实现
     * 在push的时候，总是将次小值也一起push进去
     * 当弹出的是最大值，那么也弹出这个次小值，并更新Min
     */
    public Deque<Integer> queue;
    public int Min = Integer.MAX_VALUE;

    public MinStack_155() {
        queue = new ArrayDeque<>();
    }

    public void push(int val) {
        if(Min >= val){
            queue.add(Min);
            Min = val;
        }
        queue.add(val);
    }

    public void pop() {
        if(queue.pollLast() == Min){
            Min = queue.pollLast();
        }
    }

    public int top() {
        return queue.peekLast();
    }

    public int getMin() {
        return Min;
    }
}
