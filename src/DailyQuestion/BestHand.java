package DailyQuestion;

import java.util.Arrays;

public class BestHand {

    public String bestHand(int[] ranks, char[] suits) {
        int[] dictNum = new int[13];
        int[] dictSuit = new int[4];
        for(int rank : ranks){
            dictNum[rank - 1]++;
        }
        for(char suit : suits){
            dictSuit[suit - 'a']++;
        }
        for(int i : dictSuit){
            if(i == 5){
                return "Flush";
            }
        }
        Arrays.sort(dictNum);
        for(int i = 12; i >= 0; i--){
            if(dictNum[i] >= 3){
                return "Three of a Kind";
            }else if(dictNum[i] == 2){
                return "Pair";
            }else{
                return "High Card";
            }
        }
        return "";
    }
}
