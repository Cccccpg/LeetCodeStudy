package DFS;

import Utils.TreeNode;

public class MaxDepth {

    /**
     * 最经典的找二叉树深度
     *
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
