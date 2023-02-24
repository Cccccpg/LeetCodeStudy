package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

    /**
     * 给一个二叉树，要求输出从根节点到所有叶子节点的路径
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        //如果root是叶子节点
        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++){
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null){
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null){
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
