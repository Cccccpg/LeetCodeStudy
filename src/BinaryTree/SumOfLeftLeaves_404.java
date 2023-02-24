package BinaryTree;

import Utils.TreeNode;

public class SumOfLeftLeaves_404 {

    /**
     * 计算二叉树左叶子之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root){
        int ans = 0;
        if (root == null)
            return ans;
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null){
            ans += root.left.val;
        }
        return ans + leftSum +rightSum;
    }
}
