package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindSubsequences_491 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     *
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     *
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums){
        if (nums.length == 1)
            return res;
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex){
        //终止回溯条件是子序列中要有两个以上元素
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++){
            //保证是递增子序列
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            //表示该元素本层使用过
            if (hashMap.getOrDefault(nums[i], 0) >= 1){
                continue;
            }
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
