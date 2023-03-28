package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {

    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
     * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     *
     * @param s
     * @return
     */
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12){
            return res;
        }
        backTracking(s, 0, 0);
        return res;
    }

    public void backTracking(String s, int startIndex, int pointNum){
        if (pointNum == 3){
            if (isValid(s, startIndex, s.length() - 1)){
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++){
            //判断[startIndex, i]区间内的子串是否合法,若合法，则加.
            if (isValid(s, startIndex, i)){
                //加给字符串加"."
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                backTracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else {
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end){
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        return true;
    }
}
