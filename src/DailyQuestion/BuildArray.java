package DailyQuestion;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    /**
     * 因为target是严格递增的，所以只需要判断target[j]是否等于i，
     * 如果等于，那说明进栈，打印“push”，让j++
     * 如果不等于，那说明需要出栈，就打印“push”“pop”，此时不需要将j++，
     * 因为需要判断target[j]是否与 i + 1相等
     *
     * 输入：target = [1,3], n = 3
     * 输出：["Push","Push","Pop","Push"]
     * 解释：
     * 读取 1 并自动推入数组 -> [1]
     * 读取 2 并自动推入数组，然后删除它 -> [1]
     * 读取 3 并自动推入数组 -> [1,3]
     *
     * @param target
     * @param n
     * @return
     */

    public List<String> buildArray(int[] target, int n) {
        int len = target.length, j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (j == len){
                break;
            }
            if (target[j] != i){
                list.add("Push");
                list.add("Pop");
            }else {
                j++;
                list.add("Push");
            }
        }
        return list;
    }
}
