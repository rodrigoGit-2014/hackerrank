package implementation;

import java.math.BigDecimal;

public class ExtraLongFactorial {

    public static void main(String[] args) {
        extraLongFactorials(25);
    }

    static void extraLongFactorials(int num) {

        BigDecimal result = new BigDecimal(num);
        for (int decrease = 1; decrease < num; decrease++) {
            result = result.multiply(new BigDecimal(num - decrease));
        }
        System.out.println(result);
    }

}
