package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
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
    public List<List<Integer>> levelOrder(Node root) {
        level(root);
        return result;
    }

    public void level(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();

            while(len > 0){
                Node node = queue.poll();
                temp.add(node.val);
                List<Node> children = node.children;
                for(Node child : children){
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
