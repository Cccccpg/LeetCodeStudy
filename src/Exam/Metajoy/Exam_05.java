package Exam.Metajoy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Exam_05 {
    public static void main(String[] args) {
        File file = new File("src\\Exam\\Metajoy\\test.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            //第一问
            printUp(line);
            //第二问
            printAndSplit(line);
            //第三问
            deleteTail(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印所有大写字母并按顺序输出
     * @param str
     */
    public static void printUp(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z'){
                list.add(c);
            }
        }
        Collections.sort(list);
        for (Character c : list) {
            System.out.print(c);
        }
    }

    /**
     * 将邮件中以\r\n 为分割的文本以<div></div>标签进行包裹。
     * @param str
     */
    public static void printAndSplit(String str){
        String[] strArr = str.split("\\\\r\\\\n");
        for (String s : strArr) {
            if (s == "" || s.length() == 0){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<div>");
            sb.append(s);
            sb.append("</div>");
            System.out.println(sb);
        }
    }

    /**
     * 删除尾部的Sent from my ***，并打印处理好的邮件
     * @param str
     */
    public static void deleteTail(String str){
        String[] strArr = str.split("\\\\r\\\\n");
        int len = strArr.length;
        if (strArr[len - 1].equals("Sent from my iPad") || strArr[len - 1].equals("Sent from my iPhone")
                || strArr[len - 1].equals("Sent from my Android")){
            strArr[len - 1] = "";
        }
        for (String s : strArr) {
            if (s == "" || s.length() == 0){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<div>");
            sb.append(s);
            sb.append("</div>");
            System.out.println(sb);
        }
    }
}
