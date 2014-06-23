package com.friedapps.scientycalc.calculator;

public class ExpressionItem {
    public TokenObject token;
    public TokenType type;
    public int index;

    public enum TokenType {Bracket, Constant, Variable, Operator}

    public ExpressionItem(TokenObject token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public ExpressionItem(TokenType type) {
        this.type = type;
        this.token = null;
    }

}
