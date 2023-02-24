package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_113 {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
     * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, res, path, targetSum);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, List<Integer> path, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum){
            //注意：这里不是直接用res.add(path),因为后续res指向的是path的地址，而path后面是会变的
            //所以正确的做法是，重新申请一块地址给path，再加入到res中
            res.add(new ArrayList<>(path));
        }
        if (root.left != null){
            traversal(root.left, res, path, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            traversal(root.right, res, path, targetSum - root.val);
            path.remove(path.size() - 1);
        }
    }
}
