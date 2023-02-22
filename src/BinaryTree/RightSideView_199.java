package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView_199 {


    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，
     * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        level(root, 0);
        for(int i = 0; i < result.size(); i++){
            ans.add(result.get(i).get(result.get(i).size() - 1));
        }
        return ans;
    }

    public void level(TreeNode root, Integer deep){
        if(root == null)
            return;
        deep++;
        if(result.size() < deep){
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        result.get(deep - 1).add(root.val);
        level(root.left, deep);
        level(root.right, deep);
    }
}
