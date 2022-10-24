package DailyQuestion;

public class KthGrammar {

    /**
     *
     * @param n
     * @param k
     * @return
     */

    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) % 2;
    }
}
