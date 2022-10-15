package Offer;

import Utils.TreeNode;

public class Offer55_1 {

    /**
     * 递归，求左右最大的值 + 1
     *
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        int ans = 0;
        if(root == null){
            return ans;
        }
        ans = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return ans;
    }
}
