package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {

    /**
     * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
     * 与实际答案相差 10-5 以内的答案可以被接受。
     */

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<Double> averageOfLevels(TreeNode root) {
        level(root);
        List<Double> ans = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            long sum = 0;
            for(int j = 0; j < result.get(i).size(); j++){
                sum += result.get(i).get(j);
            }
            ans.add((double)sum / (double)result.get(i).size());
        }
        return ans;
    }

    public void level(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();

            while(len > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                len--;
            }
            result.add(temp);
        }
    }
}
