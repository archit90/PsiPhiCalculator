package com.friedapps.scientycalc.calculator;

public class TokenConstant extends TokenObject {
    public double val;

    public TokenConstant(double val) {
        this.val = val;
    }

    public TokenConstant(String val) {
        this.val = convert(val);
    }

    private static double convert(String num) {
        return Double.parseDouble(num);
    }


    public static int getDigit(String s) {
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= '0' && c <= '9')
                return c - '0';
        }
        return -1;
    }
}
