package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftValue_513 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public int findBottomLeftValue(TreeNode root){
        level(root);
        return res.get(res.size() - 1).get(0);
    }

    private void level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            res.add(temp);
        }
    }
}
