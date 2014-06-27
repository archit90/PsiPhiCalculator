package com.friedapps.scificalc.calculator;

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

    public String toString() {
        return name + "(" + val + ")";
    }
}
