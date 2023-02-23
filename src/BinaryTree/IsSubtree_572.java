package BinaryTree;

import Utils.TreeNode;

public class IsSubtree_572 {

    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSametree(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null)
            return true;
        if(rootA == null || rootB == null){
            return false;
        }
        if(rootA.val != rootB.val){
            return false;
        }
        return isSametree(rootA.left, rootB.left) && isSametree(rootA.right, rootB.right);
    }
}
