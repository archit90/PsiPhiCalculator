package com.friedapps.scientycalc.calculator;

public class TokenVariable extends TokenObject {
    public String name;
    public double val;

    public TokenVariable(String n) {
        this.name = n;
    }

    public TokenVariable(String name, double val) {
        this.name = name;
        this.val = val;
    }
}
