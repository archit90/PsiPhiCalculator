package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.ButtonKeys;

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

    public static boolean isBracket(ButtonKeys.Key k) {
        return (k == ButtonKeys.Key.kBrOpen || k == ButtonKeys.Key.kBrClose);
    }

    public String toString() {
        return "Brkt" + type.toString();
    }


}
