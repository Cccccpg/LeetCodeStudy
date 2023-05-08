package String;

import java.util.Scanner;

public class ReverseStr_541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        System.out.println(reverseStr(s, k));
    }

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k){
        char[] str = s.toCharArray();
        //每隔2k个字符反转
        for (int i = 0; i < s.length(); i += 2 * k) {
            //剩余的字符小于2k，但是大于k，则反转前k个字符
            if (i + k <= s.length()){
                reverse(str, i, i + k - 1);
                continue;
            }
            //剩余字符小于k个，将剩余的都反转
            reverse(str, i, str.length - 1);
        }
        return new String(str);
    }

    public static void reverse(char[] str, int start, int end){
        for (int i = start, j = end; i < j; i++ ,j--){
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
    }
}
