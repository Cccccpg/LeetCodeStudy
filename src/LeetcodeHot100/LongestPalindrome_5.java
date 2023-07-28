package LeetcodeHot100;

public class LongestPalindrome_5 {

    //方法一：双指针往外扩散
    //有两种情况：1.两个字母往外扩散
    //		    2.一个字母往外扩散
    //扩散一直到边界，或者两个字母不一样停止
    int max = 0;
    int left = 0, right = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    public void extend(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > max){
                left = l;
                right = r;
                max = r - l + 1;
            }
            l--;
            r++;
        }
    }

    //方法二：动态规划
    //其实动态规划的方法就相当于从外向里缩
    //dp[i][j]表示字符串从i到j是不是回文串
    //当i和j所在位置字符相等时，
    // dp[i][j]共有三种情况：1.i = j时，dp[i][j] = true;
    //                   2.i = j - 1时,dp[i][j] = true
    //                   3.i < j - 1时，dp[i][j] = dp[i + 1][j - 1]
    //唯一要注意的就是遍历顺序,从下往上遍历
    public String longestPalindrome1(String s) {
        int maxLen = 0, left = 0, right = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (i == j){
                        dp[i][j] = true;
                    }else if (i == j - 1){
                        dp[i][j] = true;
                    }else if (i < j - 1){
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
