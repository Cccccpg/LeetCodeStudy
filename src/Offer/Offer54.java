package Offer;

import Utils.TreeNode;

import java.util.*;

public class Offer54 {

    /**
     * 在二叉搜索树中找第k大的节点
     * 创建list，将所有节点从小到大添加进list中
     * 然后直接返回索引为list.size() - k的节点值就行
     *
     * @param root
     * @param k
     * @return
     */

    public int kthLargest(TreeNode root, int k) {
        List<Integer> ansList = new ArrayList<>();
        helper(root, ansList);
        return ansList.get(ansList.size() - k);
    }

    private void helper(TreeNode root, List<Integer> ansList) {
        if (root == null){
            return;
        }
        if (root.left != null){
            helper(root.left, ansList);
        }
        ansList.add(root.val);
        if (root.right != null){
            helper(root.right, ansList);
        }
    }
}
