package DailyQuestion;

import java.util.Arrays;

public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0, m = -1, n = -1;
        for (int i = 0, j = 0; i < s1.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                count++;
                if (m == -1) m = i;
                if (n == -1 && m != i) n = i;
            }
        }
        if (count == 0) return true;
        if (count == 2 && s1.charAt(m) == s2.charAt(n) && s2.charAt(m) == s1.charAt(n))
            return true;
        return false;
    }
}
