package Linklist_Stack_Queue;

import java.util.Stack;

public class EvalRPN_150 {

    /**
     * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
     *
     * 请你计算该表达式。返回一个表示表达式值的整数。
     *
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(stack.isEmpty() || isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else if(token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(token.equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            }else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }else{
            return true;
        }
    }
}
