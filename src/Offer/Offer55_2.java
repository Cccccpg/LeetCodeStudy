package Offer;

import Utils.TreeNode;

public class Offer55_2 {

    /**
     *
     * 利用Offer55_1的求树深度，左右子树深度差 ≤ 1才满足
     *
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int getHigh(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHigh(root.left), getHigh(root.right))+1;
    }
}
