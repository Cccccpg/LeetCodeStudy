package Offer;

import java.util.HashMap;

public class Offer56_2 {

    /**
     * 没啥好说的，hashMap就vans了
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) == 1){
                return integer;
            }
        }
        return 0;
    }
}
