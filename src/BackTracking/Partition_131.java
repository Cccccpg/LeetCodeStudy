package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {

    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     *
     * 切割问题与组合问题的回溯算法解决类似
     * 只不过这里的startIndex就不是下一轮遍历的起始位置，而是切割线的位置
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int startIndex){
        //如果起始位置已经大于s的大小了，那么说明已经找到了一组切割方案
        if(startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                //找到子串，添加进path
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            }else{
                continue;
            }
            backTracking(s, i + 1);
            path.remove(path.size() - 1);   //弹出本次已经填好的子串
        }
    }

    /**
     * 判断字符串s是否为回文串
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isPalindrome(String s, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
