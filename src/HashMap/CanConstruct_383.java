package HashMap;

import java.util.Scanner;

public class CanConstruct_383 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ransomNote = sc.nextLine();
        String magazine = sc.nextLine();
        System.out.println(canConstruct(ransomNote, magazine));
    }

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine){
        int[] dictRansomNote = new int[26];
        int[] dictMagazine = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            dictRansomNote[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            dictMagazine[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dictRansomNote[i] != 0 && dictRansomNote[i] > dictMagazine[i]){
                return false;
            }
        }
        return true;
    }
}
