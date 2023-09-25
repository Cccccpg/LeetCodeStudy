package Exam.Metajoy;

import java.util.Arrays;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val){
        this.val = val;
    }
}

public class Exam_03 {

    public static void main(String[] args) {
        char[] preOrder = {'a','b','c','d','e','f','g','h','i','j'};
        char[] inOrder = {'c','b','e','d','a','h','g','i','j','f'};
        TreeNode root = buildTree(preOrder, inOrder);
        postPrint(root);
    }

    /**
     * 根据前序遍历和中序遍历建二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode buildTree(char[] preOrder, char[] inOrder){
        if (preOrder == null || inOrder == null
                || preOrder.length == 0 || inOrder.length == 0
                || preOrder.length != inOrder.length){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);
        int rootIndex = getIndex(inOrder, root.val);
        if (rootIndex == -1) {
            return null;
        }

        char[] leftIn = Arrays.copyOfRange(inOrder, 0, rootIndex);
        char[] leftPre = Arrays.copyOfRange(preOrder, 1, rootIndex + 1);

        //找到前序和中序中的右子树
        char[] rightIn = Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length);
        char[] rightPre = Arrays.copyOfRange(preOrder, rootIndex + 1, preOrder.length);

        //递归再次构建左右子树
        TreeNode left = buildTree(leftPre, leftIn);
        TreeNode right = buildTree(rightPre, rightIn);


        root.left = left;
        root.right = right;

        return root;
    }

    /**
     * 根据根节点的值找到中序遍历中的根节点的位置索引
     * @param arr
     * @param target
     * @return
     */
    public static int getIndex(char[] arr, int target){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 递归打印后序遍历结果
     * @param root
     */
    public static void postPrint(TreeNode root){
        if (root == null){
            return;
        }
        postPrint(root.left);
        postPrint(root.right);
        System.out.print(root.val + " ");
    }
}
