package com.friedapps.scientycalc.calculator;

public class ExpressionItem {
    public TokenObject token;
    public TokenType type;


    public enum TokenType {Bracket, Constant, Variable, Operator}

    public ExpressionItem(TokenObject token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public ExpressionItem(TokenType type) {
        this.type = type;
        this.token = null;
    }

    public static TokenConstant evalUnary(TokenOperator tOp, TokenConstant item1) {
        TokenConstant rIt = null;
        if (tOp.getType() == TokenOperator.OpType.Unary) {
            switch (tOp.getVal()) {
                case Minus:
                    rIt = new TokenConstant(-item1.val);
                    break;
                case Plus:
                    rIt = new TokenConstant(item1.val);
                    break;
                case Sin:
                    rIt = new TokenConstant(Math.sin(item1.val));
                    break;
                case Cos:
                    rIt = new TokenConstant(Math.cos(item1.val));
                    break;
                case Tan:
                    rIt = new TokenConstant(Math.tan(item1.val));
                    break;
                case Sec:
                    rIt = new TokenConstant(1 / Math.cos(item1.val));
                    break;
                case Cosec:
                    rIt = new TokenConstant(1 / Math.sin(item1.val));
                    break;
                case Cot:
                    rIt = new TokenConstant(1 / Math.tan(item1.val));
                    break;
                case Log:
                    rIt = new TokenConstant(Math.log(item1.val));
                    break;
            }
        } else return null;
        return rIt;
    }

    public static TokenConstant evalBinary(TokenOperator tOp, TokenConstant item1, TokenConstant item2) {
        TokenConstant rIt = null;
        double res;
        if (tOp.getType() == TokenOperator.OpType.Binary) {
            switch (tOp.getVal()) {
                case Add:
                    res = item1.val + item2.val;
                    rIt = new TokenConstant(res);
                    break;
                case Subtract:
                    res = item1.val - item2.val;
                    rIt = new TokenConstant(res);
                    break;
                case Multiply:
                    res = item1.val * item2.val;
                    rIt = new TokenConstant(res);
                    break;
                case Divide:
                    res = item1.val / item2.val;
                    rIt = new TokenConstant(res);
                    break;
                case Exponent:
                    res = Math.pow(item1.val, item2.val);
                    rIt = new TokenConstant(res);
                    break;
                case Modulus:
                    res = item1.val % item2.val;
                    rIt = new TokenConstant(res);
                    break;
                default:
                    break;

            }
        } else return null;
        return rIt;
    }
}
