package com.friedapps.scientycalc.calculator;

public class TokenOperator extends TokenObject {
    private Op val;
    private String symbol;
    // lower numeric value of precedence => lower precedence
    private int precedence;
    private OpAssoc assoc;
    private OpType type;

    public Op getVal() {
        return val;
    }

    public String getSymbol() {
        return symbol;
    }

    public TokenOperator(Op val, String sym, int precedence, OpAssoc assoc, OpType type) {
        this.val = val;
        this.symbol = sym;
        this.precedence = precedence;
        this.assoc = assoc;
        this.type = type;
    }

    public enum Op {
        Plus, Minus,
        Add, Subtract, Multiply, Divide, Exponent, Modulus,
        Sin, Cos, Tan, Log
    }

    public enum OpAssoc {
        Left, Right
    }

    public enum OpType {Unary, Binary}

    public OpAssoc getAssoc() {
        return assoc;
    }

    public OpType getType() {
        return type;
    }

    public static int comparePrecedence(TokenOperator o1, TokenOperator o2) {
        /* returns >0 for o1.precedence > o2.precendence
         *         =0 for equal precendence
         *         <0 otherwise
         * lower numeric value => lower precedence
         */
        return o1.precedence - o2.precedence;
    }
}
