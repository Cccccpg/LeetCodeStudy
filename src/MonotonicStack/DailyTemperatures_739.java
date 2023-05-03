package MonotonicStack;

import Utils.ArrayUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.showArray(dailyTemperatures(temperatures));
    }

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
     * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            // 如果当前元素比栈顶元素小，就直接入栈
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{
            // 如果当前元素比栈顶元素大，弹出栈顶元素，记录当前元素与栈顶元素下标之差，就是所求的结果
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
