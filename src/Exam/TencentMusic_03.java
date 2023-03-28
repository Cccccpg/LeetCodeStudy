package Exam;

public class TencentMusic_03 {

    /**
     * 小红拿到了一个仅由大写字母和小写字母组成的字符串。她想知道，在不考虑大小写的情况下，有多少对相邻的字母相等?
     *
     * 输入："aABbbc"
     * 输出：3
     *
     * @param str
     * @return
     */
    public static int getCnt(String str){
        String s = str.toUpperCase();
        int left = 0, right = 1, ans = 0;
        while(right < s.length()){
            if (s.charAt(left) == s.charAt(right)){
                ans++;
            }
            left++;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aABbcc";
        System.out.println(getCnt(str));
    }
}
