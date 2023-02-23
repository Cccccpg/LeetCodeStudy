package BinaryTree;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes_222 {

    /**
     * 求完全二叉树的节点总数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root){
        //return getNodeSum(root);
//        方法一：层序遍历方法
//        int sum = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root == null){
//            return sum;
//        }
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int len = queue.size();
//            while(len > 0){
//                TreeNode node = queue.poll();
//                sum++;
//                if(node.left != null){
//                    queue.offer(node.left);
//                }
//                if(node.right != null){
//                    queue.offer(node.right);
//                }
//                len--;
//            }
//        }
//        return sum;
        //方法三：利用完全二叉树性质
        if (root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while(right != null){
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth){
            return (2 << rightDepth) - 1;
        }
        int leftNodeSum = countNodes(root.left);
        int rightNodeSum = countNodes(root.right);
        int sum = leftNodeSum + rightNodeSum + 1;
        return sum;
    }

    //方法二：普通的递归方法
    private int getNodeSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = getNodeSum(root.left);
        int rightSum = getNodeSum(root.right);
        int sum = leftSum + rightSum + 1;
        return sum;
    }


}
