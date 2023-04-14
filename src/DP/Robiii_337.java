package DP;

import Utils.TreeNode;

public class Robiii_337 {

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     *
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     *
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     *
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root){
        int[] res = robActive(root);
        // 0表示不偷该节点，1表示偷该节点
        return Math.max(res[0], res[1]);
    }

    private int[] robActive(TreeNode root) {
        int[] res = new int[2];
        if (root == null){
            return res;
        }
        // 后序遍历，左右根
        int[] left = robActive(root.left);
        int[] right = robActive(root.right);

        // 不偷当前节点，那么左右孩子节点可偷可不偷，需要比较一下偷的时候和不透的时候，哪种情况值最大
        // 那么值就应该是偷左孩子节点时和不偷左孩子节点时的最大值，加上偷右孩子和不偷右孩子节点时最大值
        // 再两个值相加，就是 此时偷得最大的值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点，那么一定不偷左右孩子节点
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
