package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();


    public List<List<Integer>> levelOrder(TreeNode root) {
        level1(root, 0);
        level2(root);
        return resultList;
    }

    //深度优先搜索DFS-递归
    private void level1(TreeNode root, Integer deep) {
        if (root == null)
            return;
        deep++;
        if (resultList.size() < deep){
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resultList.add(item);
        }
        resultList.get(deep - 1).add(root.val);
        level1(root.left, deep);
        level1(root.right, deep);
    }

    //广度优先搜索BFS-迭代
    private void level2(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len > 0){
                TreeNode node = queue.poll();
                itemList.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                len--;
            }
            resultList.add(itemList);
        }
    }
}
