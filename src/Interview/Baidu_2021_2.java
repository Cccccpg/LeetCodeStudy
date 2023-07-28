package Interview;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Baidu_2021_2 {

    /**
     * 二叉树的层序遍历
     * @param root
     */
    public void sequenceTraversal(TreeNode root){
        if (root == null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.pop();
            if (p.left != null){
                queue.offer(p.left);
            }
            if (p.right != null){
                queue.offer(p.right);
            }
        }
    }
}
