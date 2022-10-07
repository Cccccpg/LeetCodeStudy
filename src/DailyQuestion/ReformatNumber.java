package DailyQuestion;

public class ReformatNumber {

    /**
     * 其实就是分割字符串然后分情况讨论
     *
     * @param number
     * @return
     */

    public String reformatNumber(String number) {
        number = number.replaceAll("[- ]", "");
        StringBuilder sb = new StringBuilder();
        while (number.length() > 4) {
            sb.append(number.substring(0, 3));
            sb.append("-");
            number = number.substring(3);
        }
        if (number.length() == 4) {
            sb.append(number.substring(0, 2));
            sb.append("-");
            sb.append(number.substring(2));
        } else {
            sb.append(number);
        }
        return sb.toString();
    }
}
