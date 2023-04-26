package Exam;
import Utils.BuildTree;
import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yuewen_01 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    /**
     * 给你两棵二叉树 s 和 t 。检验 s 中是否包含和 t 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     *
     * 输入：
     * 3 4 5 1 2 # # # # 0
     * 4 1 2
     * 输出：
     * false
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        TreeNode s = buildTree(str1);
        TreeNode t = buildTree(str2);

        System.out.println(isSubtree(s, t));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.val != t.val){
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // 根据层序遍历建树
    public static TreeNode buildTree(String str){
        if (str.equals("")){
            return null;
        }
        String[] nodes = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int index = 0;
        queue.add(root);

        while (index < nodes.length - 1){
            //弹出根节点
            TreeNode node = queue.remove();
            //拿左指针
            index++;
            if (!nodes[index].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
                node.left = left;
                queue.add(left);
            }
            //没有右指针的情况
            if (index == nodes.length - 1){
                break;
            }
            //拿右指针
            index++;
            if (!nodes[index].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[index]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
