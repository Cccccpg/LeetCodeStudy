package LeetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAnagrams_438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p){
        // 这种方法时间复杂度很高，因为滑动窗口是在字符串上滑
        // 题目中的字符串很长，最长有三万个字符
//        int window = p.length();
//        int index = 0;
//        ArrayList<Integer> ansList = new ArrayList<>();
//        while(index <= s.length() - window){
//            if (isAnagrams(s.substring(index, index + window), p)){
//                ansList.add(index);
//            }
//            index++;
//        }
//        return ansList;

        // 将滑动窗口放在dict表上，每p个p个加入dict进行对比
        ArrayList<Integer> ansList = new ArrayList<>();
        if(p.length() > s.length()){
            return ansList;
        }
        int[] dictA = new int[26];
        int[] dictB = new int[26];
        for (int i = 0; i < p.length(); i++) {
            dictA[s.charAt(i) - 'a']++;
            dictB[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(dictA, dictB)){
            ansList.add(0);
        }
        for(int i = p.length(); i < s.length(); i++){
            dictA[s.charAt(i - p.length()) - 'a']--;
            dictA[s.charAt(i) - 'a']++;
            if(Arrays.equals(dictA, dictB)){
                ansList.add(i - p.length() + 1);
            }
        }
        return ansList;
    }

    public static boolean isAnagrams(String a, String b){
        int[] dictA = new int[26];
        int[] dictB = new int[26];
        for (int i = 0; i < a.length(); i++) {
            dictA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            dictB[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < dictA.length; i++) {
            if (dictA[i] != dictB[i]){
                return false;
            }
        }
        return true;
    }
}
