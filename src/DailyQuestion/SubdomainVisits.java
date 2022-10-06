package DailyQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisits {

    /**
     * 主要就是运用split分割字符串，分为前面的数字部分和后面的字符串部分
     * 然后将字符串和数字存放在HashMap中
     * 最后遍历HashMap，将结果添加到结果List中返回
     *
     * 输入：cpdomains = ["9001 discuss.leetcode.com"]
     * 输出：["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
     *
     * @param cpdomains
     * @return
     */

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String , Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] strArr = cpdomains[i].split(" ");
            int count = Integer.parseInt(strArr[0]);
            hashMap.put(strArr[1],
                    hashMap.getOrDefault(strArr[1], 0) + count);
            String[] strIP = strArr[1].split("\\.");
            if (strIP.length == 2){
                hashMap.put(strIP[1],
                        hashMap.getOrDefault(strIP[1], 0) + count);
            }else if (strIP.length == 3){
                StringBuilder sb = new StringBuilder();
                String d2d3 = sb.append(strIP[1]).append(".").append(strIP[2]).toString();
                hashMap.put(d2d3,
                        hashMap.getOrDefault(d2d3, 0) + count);
                hashMap.put(strIP[2],
                        hashMap.getOrDefault(strIP[2], 0) + count);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String str : hashMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            list.add(stringBuilder.append(hashMap.get(str)).append(" ").append(str).toString());
        }
        return list;
    }
}
