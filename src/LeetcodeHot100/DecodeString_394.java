package LeetcodeHot100;

public class DecodeString_394 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String str;
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num =num * 10 + s.charAt(i) - '0';
            }else if(s.charAt(i) != '[' && s.charAt(i) != ']'){
                sb.append(s.charAt(i));
            }
            if(s.charAt(i) == '['){
                int start = i;
                int count = 1;
                while(count != 0){
                    i++;
                    if(s.charAt(i) == '['){
                        count++;
                    }
                    if(s.charAt(i) == ']'){
                        count--;
                    }
                }
                str = decodeString(s.substring(start + 1, i));
                while(num > 0){
                    sb.append(str);
                    num--;
                }
            }
        }
        return sb.toString();
    }
}
