package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     *
     * 输入：n = 4, k = 2
     * 输出：
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *
     *  回溯三部曲
     *
     * @param n
     * @param k
     * @return
     */

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k){
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
