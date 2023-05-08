package String;

import java.util.Scanner;

public class strStr_28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle){
        int left = 0, right = needle.length() - 1;
        while(right < haystack.length()){
            if (haystack.substring(left, right + 1).equals(needle)){
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }
}
