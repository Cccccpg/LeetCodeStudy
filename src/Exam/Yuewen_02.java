package Exam;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yuewen_02 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 判断一个树是否为平衡二叉树
     *
     * 示例1：
     * 输入：
     * 3 9 20 # # 15 7
     * 输出：
     * true
     *
     * 示例2：
     * 输入：
     * 1 2 2 3 3 # # 4 4
     * 输出：
     * false
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        TreeNode root = buildTree(str);
        System.out.println(isBalanceTree(root));
    }

    public static boolean isBalanceTree(TreeNode root){
        if (root == null){
            return true;
        }
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1){
            return isBalanceTree(root.left) && isBalanceTree(root.right);
        }
        return false;
    }

    public static int getHigh(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
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
