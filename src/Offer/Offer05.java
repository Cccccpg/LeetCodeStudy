package Offer;

public class Offer05 {

    /**
     * 把字符串s中的每个空格替换成“%20”
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
