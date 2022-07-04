package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/6/29
 * 分数到小数
 */
public class L166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder sb = new StringBuilder();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append("-");
        }

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append(".");

        // 小数部分
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if (remainder != 0) { // 有循环
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart);
        return sb.toString();
    }

    public static void main(String[] args) {
        L166 test = new L166();
        System.out.println(test.fractionToDecimal(1, 6));
    }
}
