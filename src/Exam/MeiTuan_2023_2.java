package Exam;

import java.util.HashMap;
import java.util.Scanner;

public class MeiTuan_2023_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int c = sc.nextInt();
            int sum = c / k;
            int mod = c % k;
            if (mod != 0){
                sum++;
            }
            for (int j = 1; j < k; j++) {
                int num = sc.nextInt();
                if (map.get(num) != null){
                    map.put(num, sum + map.get(num));
                }else{
                    map.put(num, sum);
                }
            }
        }
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
    }
}
