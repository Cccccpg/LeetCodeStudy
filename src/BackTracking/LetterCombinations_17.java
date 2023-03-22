package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return result;
        backtracking(digits, 0);
        return result;
    }

    public void backtracking(String digits, int index){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String str = map[digit];
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
