package BinaryTree;

import Utils.TreeNode;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.*;

public class LevelOrderBottom_107 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //level(root, 0);
        level1(root);
        Collections.reverse(result);
        return result;
    }

    //递归
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

    //迭代
    private void level1(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();

            while (len > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                len--;
            }
            result.add(temp);
        }
    }
}
