package LeetcodeHot100;

import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int[] dict = new int[96];
        int ans = 0, index = 0;
        for(int i = 0; i < s.length(); i++){
            if (dict[s.charAt(i) - ' '] != 0){
                ans = Math.max(dictLen(dict), ans);
                while (s.charAt(index) != s.charAt(i)){
                    dict[s.charAt(index) - ' ']--;
                    index++;
                }
                dict[s.charAt(index) - ' ']--;
                index++;
            }
            dict[s.charAt(i) - ' ']++;
        }
        return Math.max(ans, dictLen(dict));
    }

    public static int dictLen(int[] nums){
        int count = 0;
        for(int num : nums){
            if (num == 1){
                count++;
            }
        }
        return count;
    }
}
