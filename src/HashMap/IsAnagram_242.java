package HashMap;

import java.util.Scanner;

public class IsAnagram_242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram(s, t));
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            dict2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dict1[i] != dict2[i]){
                return false;
            }
        }
        return true;
    }
}
