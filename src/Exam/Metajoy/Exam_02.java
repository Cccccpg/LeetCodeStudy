package Exam.Metajoy;

import java.util.HashSet;

public class Exam_02 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,5,5,7};
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            System.out.print(num + " ");
        }
    }
}
