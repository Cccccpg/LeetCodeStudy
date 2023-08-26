package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class WhatToEat {

    private static String[] meatDish = {"莴笋肉丝","青椒肉丝","泡椒猪肝", "鱼香肉丝",
            "木耳肉丝","小炒肉","盐煎肉", "宫保鸡丁","蒜头肉丝"};

    private static String[] vegetableDish = {"炒时蔬","炒豆干","麻婆豆腐","番茄炒蛋",
            "红烧茄子","炒丝瓜","空心菜","炒玉米", "苦瓜炒蛋","韭菜炒蛋","虎皮青椒",
            "泡椒血旺","红烧豆腐","花生米","干煽四季豆","青椒皮蛋"};

    private static String[] deliciousDish = {"尖椒鸡","歌乐辣子鸡","水煮肉片","泡椒牛肉",
            "泡椒牛蛙","辣子肥肠","水煮牛肉","水煮牛蛙","水滑肉","尖椒兔","辣子兔","毛血旺",
            "干锅鸡","荤豆花","干锅兔","姜爆鸭子","酸菜鱼","麻辣鱼"};

    public static void main(String[] args) {
        int n = 4;
        System.out.println("今天吃：" + decideWhatToEat(n) + ", " + n + "份饭");
    }

    private static String decideWhatToEat(int num){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        if (num >= meatDish.length){
            return "干饭人太多了！建议全点了";
        }
        if (num == 1){
            return "食堂";
        }
        int meatDishNum = 0;
        if (num == 2){
            meatDishNum = num - 1;
        }else{
            meatDishNum = num - 2;
        }

        // 使用Set来存储已选索引，确保不重复选择
        HashSet<Integer> selectedIndices = new HashSet<>();

        for (int i = 0; i < meatDishNum; i++) {
            int index;
            do {
                // 生成随机索引
                index = random.nextInt(meatDish.length);
            } while (selectedIndices.contains(index)); // 如果已选过，重新生成

            // 记录已选索引
            selectedIndices.add(index);

            if (i > 0) {
                sb.append(", ");
            }
            // 添加选中的值到StringBuilder
            sb.append(meatDish[index]);
        }
        int randomVegetableIndex = random.nextInt(vegetableDish.length);
        sb.append(", "+ vegetableDish[randomVegetableIndex]);
        return sb.toString();
    }
}
