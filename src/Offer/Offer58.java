package Offer;

public class Offer58 {

    /**
     * 将字符串前面锐欧干个字符转移到字符串的尾部
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < n){
                sb1.append(s.charAt(i));
            }else {
                sb2.append(s.charAt(i));
            }
        }
        return sb2.append(sb1).toString();
    }
}
