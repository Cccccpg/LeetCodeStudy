package DP;

public class LongestPalindrome_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("cbbd"));
    }

    // DP
    public static String longestPalindrome(String s) {
        int maxLength = 0, left = 0, right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j <s.length(); j++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(i >= j - 1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    // 使用双指针中心扩散
    static int left = 0, right = 0;
    static int maxLen = 0;
    public static String longestPalindrome1(String s) {
        for (int i = 0; i < s.length(); i++) {
            //以i为中心开始扩散
            extend(s, i, i);
            //以i和i+1为中心开始扩散
            extend(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private static void extend(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if (r - l + 1 > maxLen){
                left = l;
                right = r;
                maxLen = r - l + 1;
            }
            l--;
            r++;
        }
    }
}
