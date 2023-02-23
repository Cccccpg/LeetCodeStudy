package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect_117 {

    /**
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL 。
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null)
            return null;
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            Node node = null;
            Node preNode = null;

            for(int i = 0; i < len; i++){
                if(i == 0){
                    preNode = queue.poll();
                    node = preNode;
                }else{
                    node = queue.poll();
                    preNode.next = node;
                    preNode = preNode.next;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            preNode.next = null;
        }
        return root;
    }
}
