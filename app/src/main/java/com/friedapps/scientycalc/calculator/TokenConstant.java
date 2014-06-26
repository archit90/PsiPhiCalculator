package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.ButtonKeys;

import java.text.DecimalFormat;

public class TokenConstant extends TokenObject {
    public double val;
    private static final DecimalFormat decFormat = new DecimalFormat("0." + repeat("#", 12));
    private static final DecimalFormat intFormat = new DecimalFormat("0");
    private static final DecimalFormat scienFormat = new DecimalFormat("#E");

    private static String repeat(String pattern, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; ++i)
            sb.append(pattern);
        return sb.toString();
    }

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

    public String toString() {
        if (val >= 0) {
            if (val == Math.floor(val))
                return intFormat.format(val);
            else
                return decFormat.format(val);
        } else {
            if (val == Math.ceil(val))
                return intFormat.format(val);
            else
                return decFormat.format(val);
        }
    }

}
