package DailyQuestion;

public class PartitionDisjoint {

    /**
     * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     *
     * 输入：nums = [1,1,1,0,6,12]
     * 输出：4
     * 解释：left = [1,1,1,0]，right = [6,12]
     *
     * 本质就是找左边数组的最大值，右边数组的最小值要大于左边数组的最大值，定义两个值
     * max表示遍历到当前位置的最大值，leftMax 表示左边数组中最大值
     * 从左往右遍历，如果nums[i] < leftMax 那说明当前值属于左边数组，就可以把当前最大值 max 给leftMax，因为此时的max一定是左边数组的最大值
     * 然后继续向右找，直到结束寻找
     *
     * @param nums
     * @return
     */

    public int partitionDisjoint(int[] nums) {
        int max = nums[0], leftMax = nums[0], index = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < leftMax){
                leftMax = max;
                index = i;
            }
        }
        return index + 1;
    }
}
