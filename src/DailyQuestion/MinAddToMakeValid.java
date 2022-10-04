package DailyQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinAddToMakeValid {
    public static int minAddToMakeValid(String s) {
        int ans = 0;
        Deque<Character> stack =  new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.addFirst(s.charAt(i));
            }else {
                if (stack.isEmpty()){
                    ans++;
                }else {
                    stack.pop();
                }
            }
        }
        return ans+stack.size();
    }
}
