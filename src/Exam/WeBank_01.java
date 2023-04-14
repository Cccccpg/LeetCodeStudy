package Exam;

public class WeBank_01 {
    public static int countNumbers(int L,int R,int X,int Y){
        int[] ones =new int[1000001];
        for(int i=1; i <=1000000; i++) {
            ones[i] = ones[i >>1] + (i &1);
        }
        int ans=0;
        for(int N=0; N <=1000000; N++) {
            if(ones[N] >= L && ones[N] <= R && (N & X) == X && (N | Y) == Y) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countNumbers(2,3,8,62));
    }
}
