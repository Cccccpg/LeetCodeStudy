package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        pre(root, result);
        return result;
    }

    public void pre(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        result.add(root.val);
        pre(root.left, result);
        pre(root.right, result);
    }
}
