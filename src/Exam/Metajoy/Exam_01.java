package Exam.Metajoy;

import java.util.Scanner;

public class Exam_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1'){
                sb.append("0");
            }else{
                sb.append("1");
            }
        }
        System.out.println(sb.reverse());
    }
}
