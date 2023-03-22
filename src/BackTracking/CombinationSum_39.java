package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     *
     * 使用回溯算法模板，注意本题中数字是可以被重复选择的
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);        //排序后更方便计算，相当于剪枝
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex){
        //判断终止回溯的条件，也即和为目标值
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(sum + candidates[i] > target)
                break;
            path.add(candidates[i]);
            backTracking(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
