package Offer;

import Utils.TreeNode;

public class Offer68_2 {

    /**
     * 直接回溯
     * 1、p q 一个在左子树 一个在右子树，那么当前节点root就是最近公共祖先
     * 2、p q 都在左子树，那就是left
     * 3、p q 都在右子树，那就是right
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            //一个在左，一个在右
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
