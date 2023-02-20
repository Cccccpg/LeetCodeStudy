package BinaryTree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IteratedTraversal {

    //前序遍历迭代写法
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                //将该节点弹出，避免重复操作，下面再将右左中节点放入栈中
                stack.pop();
                //添加右节点
                if (node.right != null){
                    stack.push(node.right);
                }
                //添加左节点
                if (node.left != null){
                    stack.push(node.left);
                }
                //添加中节点
                stack.push(node);
                //因为中节点访问过，但还没处理，所以加入空节点进行标记
                stack.push(null);
            }else{
                //只有遇到空节点的时候，才将下一个节点放进结果集
                //弹出空节点
                stack.pop();
                //重新取出栈中元素
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    //中序遍历迭代写法
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                //弹出栈顶元素，避免重复操作
                stack.pop();
                //添加右节点
                if (node.right != null){
                    stack.push(node.right);
                }
                //添加中节点
                stack.push(node);
                stack.push(null);
                //添加左节点
                if (node.left != null){
                    stack.push(node.left);
                }
            }else{
                //弹出空节点
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    //后序遍历迭代写法
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                //添加中节点
                stack.push(node);
                stack.push(null);
                //添加右节点
                if (node.right != null){
                    stack.push(node.right);
                }
                //添加左节点
                if (node.left != null){
                    stack.push(node.left);
                }
            }else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }


























}
