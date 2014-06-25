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

    @Override
    public String toString() {
        switch (type) {
            case Bracket:
                return ((TokenBracket) token).type.toString();
            case Constant:
                return ((TokenConstant) token).val + "";
            case Variable:
                return ((TokenVariable) token).name;
            case Operator:
                return ((TokenOperator) token).getVal().toString();
            default:
                return null;
        }
    }
}
