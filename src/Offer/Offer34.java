package Offer;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {

    /**
     * 找到所有从根节点到叶子结点路径总和等于给定目标和的路径
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     */

    public List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        DFS(root, target, new ArrayList<>());
        return ans;
    }

    private void DFS(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
        }else {
            DFS(root.left, target, list);
            DFS(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}
