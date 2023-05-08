package String;

import java.util.Scanner;

public class RepeatedSubstringPattern_459 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s){
        if ((s.length() & 1) == 1){
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        int fistNotZero = 0;
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != 0){
                fistNotZero = dict[i];
                break;
            }
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != 0 && dict[i] != fistNotZero){
                return false;
            }
        }
        return true;
    }
}
