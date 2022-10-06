package Offer;

import java.util.ArrayList;
import java.util.Comparator;

public class Offer45 {

    /**
     * 输入一个非负整数，将数组中所有数字拼接成一个数，打印出拼接数字最小的一个
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *
     * 灵活使用list中的sort排序，将整数数字转换成String添加到list中
     * 再根据条件o1 + o2 < o2 + o1进行排序
     *
     * @param nums
     * @return
     */

    public String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        //根据o1 + o2 < o2 + o1的顺序进行排序
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
