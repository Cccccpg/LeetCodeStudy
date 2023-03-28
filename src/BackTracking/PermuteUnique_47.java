package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique_47 {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums){
        //这里的used数组最好放在局部变量中
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return result;
    }

    public void backTracking(int[] nums, boolean[] used){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            //树层去重
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
                continue;
            }
            //树枝去重
            if (used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
