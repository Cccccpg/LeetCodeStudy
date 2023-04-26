package Utils;
import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    // 根据输入的层序遍历建树
    public TreeNode buildTree(String str){
        //如果为空则返回null
        if (str.equals("")){
            return null;
        }
        String[] nodes = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int i = 0;
        queue.add(root);

        while (i < nodes.length - 1){
            //弹出根节点
            TreeNode node = queue.remove();
            //取左孩子节点
            i++;
            if (!nodes[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                queue.add(left);
            }
            //没有右孩子节点的情况
            if (i == nodes.length - 1){
                break;
            }
            //取右孩子节点
            i++;
            if (!nodes[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
