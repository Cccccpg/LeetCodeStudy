package DailyQuestion;

public class CheckOnesSegment {
    public static boolean checkOnesSegment(String s) {
        String[] str =  s.split("0");
        if(str.length == 1){
            return true;
        }else{
            return false;
        }
    }
}
