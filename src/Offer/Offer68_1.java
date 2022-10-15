package Offer;

import Utils.TreeNode;

public class Offer68_1 {

    /**
     * 利用二叉搜索树的性质
     * 如果root值 ＞ 给出的p，q两值，那说明root肯定不是最近的公共祖先，继续找root.left是不是
     * 如果root值 ＜ 给出的p，q两值，那说明root也肯定不是，继续找root.right是不是
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val > q.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < q.val && root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
