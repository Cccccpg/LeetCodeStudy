package String;

import java.util.Scanner;

public class ReverseWords_151 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverseWords(s));
    }

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * 输入：s = "the  sky is blue"
     * 输出："blue is sky the"
     *
     * 不用java的内置方法实现
     * @param s
     * @return
     */
    public static String reverseWords(String s){
        // 1.去除字符串中间多余的空格
        int left = 0, right = s.length() - 1;
        while(s.charAt(left) == ' '){
            left++;
        }
        while(s.charAt(right) == ' '){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while(left <= right){
            if (s.charAt(left) != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(s.charAt(left));
            }
            left++;
        }
        // 2.反转整个字符串
        char[] ch = sb.toString().toCharArray();
        reverse(ch, 0, ch.length - 1);
        // 3.反转单个字符
        int start = 0, end = 0;
        for (int i = 0; i < ch.length; i++){
            //遇到空格就反转单个字符
            if (ch[end] == ' ' ){
                reverse(ch, start, end - 1);
                start = end + 1;
            }else if (end == ch.length - 1){
                reverse(ch, start, end);
            }
            end++;
        }
        return new String(ch);
    }

    public static void reverse(char[] ch, int start, int end){
        for (int i = start, j = end; i < j; i++, j--){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
