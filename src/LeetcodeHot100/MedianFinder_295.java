package LeetcodeHot100;

import java.util.PriorityQueue;

public class MedianFinder_295 {

    /**
     * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
     *
     * 例如 arr = [2,3,4] 的中位数是 3 。
     * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
     *
     * 用两个优先队列，分别维护两个优先队列，当添加元素时，维持两个队列元素数量
     */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /**
     * MedianFinder() 初始化 MedianFinder 对象。
     */
    public MedianFinder_295() {
        min = new PriorityQueue<>();                            //从小到大
        max = new PriorityQueue<>((a, b) -> {return b - a;});   //从大到小
    }

    /**
     * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
     * @param num
     */
    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if(min.size() > max.size()){
            max.add(min.remove());
        }
    }

    /**
     * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
     * @return
     */
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek()) / 2.0;
        }else{
            return max.peek();
        }
    }
}
