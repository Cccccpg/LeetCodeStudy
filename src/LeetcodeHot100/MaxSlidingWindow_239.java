package LeetcodeHot100;

import java.util.ArrayDeque;

public class MaxSlidingWindow_239 {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 这题用暴力做会超时，只能用单调队列来做。
     * 可以使用双端队列来实现单调队列。
     * 每次弹出的时候需要判断，弹出的值是否等于队列出口元素的值，如果是，那么队列弹出元素；
     * 每次添加元素时要判断添加的元素是否大于入口元素的值，如果是，那么就将队列入口的元素弹出，直到添加的元素小于等于队列入口的元素
     * 保持以上的规则，这样每次窗口移动的时候，只需要查询双端队列的队头就可以返回当前窗口的最大值。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 用单调队列来存储下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            // 队头节点需要在窗口范围内，不符合的要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 要保证每次放进去的数字要比末尾的数字大，不符合也要弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            // 因为单调，当i增长到符合第一个窗口的范围时，每滑动一步，都将队头节点放入结果集
            if(i >= k - 1){
                ans[index++] = nums[deque.peek()];
            }
        }
        return ans;
    }
}
