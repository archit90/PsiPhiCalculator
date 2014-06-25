package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.ButtonKeys;

public class TokenOperator extends TokenObject {
    private Op val;
    private ButtonKeys.Key key;
    // lower numeric value of precedence => lower precedence
    private int precedence;
    private OpAssoc assoc;
    private OpType type;
    private OpKind kind;

    public ButtonKeys.Key getKey() {
        return key;
    }

    public Op getVal() {
        return val;
    }

    public TokenOperator(Op val, ButtonKeys.Key key, int precedence, OpAssoc assoc,
                         OpType type, OpKind kind) {
        this.val = val;
        this.key = key;
        this.precedence = precedence;
        this.assoc = assoc;
        this.type = type;
        this.kind = kind;
    }

    public enum Op {
        Minus,
        Add, Subtract, Multiply, Divide, Exponent, Modulus,
        Sin, Cos, Tan, Log
    }

    public enum OpAssoc {
        Left, Right
    }

    public enum OpKind {
        infix, prefix, postfix
    }

    public enum OpType {Unary, Binary}

    public OpAssoc getAssoc() {
        return assoc;
    }

    public OpType getType() {
        return type;
    }

    public OpKind getKind() {
        return kind;
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
