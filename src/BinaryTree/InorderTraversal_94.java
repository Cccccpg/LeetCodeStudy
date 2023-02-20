package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        in(root, result);
        return result;
    }

    private void in(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        in(root.left, result);
        result.add(root.val);
        in(root.right, result);
    }
}
