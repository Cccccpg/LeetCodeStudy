package BackTracking;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums){
        used = new boolean[nums.length];
        backTracking(nums);
        return result;
    }

    public void backTracking(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
