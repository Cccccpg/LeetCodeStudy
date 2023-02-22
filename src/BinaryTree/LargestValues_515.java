package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues_515 {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    /**
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     *
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        level(root);
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < result.size(); i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < result.get(i).size(); j++){
                max = Math.max(max, result.get(i).get(j));
            }
            ans.add(max);
        }
        return ans;
    }

    public void level(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();

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
