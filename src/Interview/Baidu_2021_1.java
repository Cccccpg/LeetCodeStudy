package Interview;

import java.util.Scanner;

public class Baidu_2021_1 {

    /**
     * 给定一个字符串比如“abcdef”，要求写个函数变成“defabc”，位数是可变的。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();

        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        System.out.println(s2 + s1);
    }
}
