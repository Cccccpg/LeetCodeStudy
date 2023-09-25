package Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Computer {
    static Map<Operator, IComputer> computers;
    static{
        computers = new HashMap<Operator, IComputer>(){{
            put(Operator.ADD, new IComputer() {
                public BigDecimal compute(BigDecimal num1, BigDecimal num2) {
                    return num1.add(num2);
                }
            });
            put(Operator.SUB, ((num1, num2) -> num1.subtract(num2)));
            put(Operator.MULTI, ((num1, num2) -> num1.multiply(num2)));
            put(Operator.DIVIDE, (num1, num2) -> num1.divide(num2));
        }};
    }
    public static void main(String[] args) {
        BigDecimal result = compute(Operator.SUB, BigDecimal.valueOf(3), BigDecimal.valueOf(2));
        System.out.println(result);
    }

    public static BigDecimal compute(Operator operator, BigDecimal num1, BigDecimal num2) {
        BigDecimal result = computers.get(operator).compute(num1, num2);
        return result;
    }

     enum Operator{
        ADD,SUB,MULTI,DIVIDE;
     }
    interface IComputer {
        BigDecimal compute(BigDecimal num1, BigDecimal num2);
    }
}
