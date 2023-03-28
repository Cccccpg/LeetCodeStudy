package Exam;

import Utils.TreeNode;

public class TencentMusic_01 {

    /**
     * 小红拿到了一个二叉树，二叉树共有n个节点。小红希望你将所有节点赋值为1到n的正整数，且没有两个节点的值相等。
     * 需要满足:奇数层的权值和与偶数层的权值和之差的绝对值不超过1。
     * 如果有多种赋值方案，请返回任意一种方案。如果无解，请返回空树。
     *
     * 输入：{-1,-1,-1,#,-1,-1}
     * 输出：{1,3,4,#,2,5}
     *
     * @param root
     * @param n
     * @return
     */

    public TreeNode buildTree(TreeNode root, int n) {
        int mid = n / 2;
        root.val = mid;
        if (root.left != null){
            buildTree(root.left, mid - 1);
        }
        if (root.right != null){
            buildTree(root.right, mid + 1);
        }
        return null;
    }

}
