package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.ButtonKeys;

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

    public static int getDigit(ButtonKeys.Key k) {
        switch (k) {
            case k0:
                return 0;
            case k1:
                return 1;
            case k2:
                return 2;
            case k3:
                return 3;
            case k4:
                return 4;
            case k5:
                return 5;
            case k6:
                return 6;
            case k7:
                return 7;
            case k8:
                return 8;
            case k9:
                return 9;
            default:
                return -1;
        }
    }
}
