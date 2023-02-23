package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
};

public class LevelOrderN_429 {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    /**
     * 层序遍历N叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NNode root) {
        level(root);
        return result;
    }

    public void level(NNode root){
        if(root == null)
            return;
        Queue<NNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();

            while(len > 0){
                NNode node = queue.poll();
                temp.add(node.val);
                List<NNode> children = node.children;
                for(NNode child : children){
                    if(child != null){
                        queue.offer(child);
                    }
                }
                len--;
            }
            result.add(temp);
        }
    }
}
