package Linklist_Stack_Queue;

import java.util.Stack;

public class ValidParentheses_20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) =='{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(s.charAt(i) == ')' && top != '('){
                    return false;
                }
                if (s.charAt(i) == '}' && top != '{'){
                    return false;
                }
                if (s.charAt(i) == ']' && top != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
