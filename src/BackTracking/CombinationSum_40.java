package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_40 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。 
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     *
     * 本题与39题不一样的地方就在与解集中不能包含重复的组合，所以需要去重，也即同一层中不能出现使用过的元素
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(sum + candidates[i] > target){
                break;
            }
            //正确剔除重复解的方法
            //跳过同一树层使用过的元素
            if(i > startIndex && candidates[i] == candidates[i - 1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i + 1);//i+1表示当前组内元素只使用一次
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
