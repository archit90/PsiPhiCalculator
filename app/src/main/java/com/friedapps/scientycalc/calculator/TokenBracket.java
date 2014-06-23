package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.calculator.ButtonKeys.Keys;

public class TokenBracket extends TokenObject {
    public enum BracketType {Open, Close}

    public BracketType type;

    public TokenBracket(BracketType type) {
        this.type = type;
    }

    public static boolean isBracket(String ch) {
        if (ch.length() == 1) {
            if (ch.equals("(") || ch.equals(")")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBracket(Keys k) {
        return (k == Keys.kBrClose || k == Keys.kBrOpen);
    }


}
