package com.friedapps.scientycalc.calculator;


import com.friedapps.scientycalc.calculator.ExpressionItem.TokenType;
import com.friedapps.scientycalc.calculator.TokenBracket.BracketType;
import com.friedapps.scientycalc.calculator.TokenOperator.OpType;

public class Tokenizer {

    public Expression infix;
    private int ctr;
    private TokenType lastTokenType = null;
    private BracketType lastBracketType = null;
    private OpType lastOperatorType = null;
    private String dnum = null;

    public Tokenizer() {
        infix = new Expression();
        ctr = 0;
        dnum = "";
    }

    public boolean addToken(String crumb) {
        // TODO: implement ctr
        boolean isDot = false, isNum = false;
        if (crumb.length() == 0 && dnum.length() > 0) {
            TokenConstant tC = new TokenConstant(dnum);
            ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
            infix.expr.add(ei);
        } else if (crumb.equals(" ")) {
            return true;
        } else if ((isDot = crumb.equals(".")) || (isNum = (TokenConstant.getDigit(crumb) >= 0))) {
            if (lastTokenType == TokenType.Constant) {
                if ((isDot && dnum.indexOf('.') < 0) || isNum) {
                    dnum += crumb;
                } else {
                    // decimal point already exists
                    // TODO: throw error NumberFormatException
                    System.out.println("Decimal point already exists");
                }
            } else {
                dnum = crumb;
            }
            lastTokenType = TokenType.Constant;
        } else if (AllOperators.isOperator(crumb)) {
            if (lastTokenType == TokenType.Constant) {
                TokenConstant tC = new TokenConstant(dnum);
                ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
                infix.expr.add(ei);
                dnum = "";
            }
            TokenOperator tOp = null;
            // distinguish between Unary or Binary depending on type of lastOperator or lastBracket
            if (lastTokenType == TokenType.Constant || lastTokenType == TokenType.Variable ||
                    (lastTokenType == TokenType.Bracket && lastBracketType == BracketType.Close)) {
                tOp = AllOperators.getOperator(crumb, TokenOperator.OpType.Binary);
                lastOperatorType = TokenOperator.OpType.Binary;
            } else if ((lastTokenType == TokenType.Operator && lastOperatorType == TokenOperator.OpType.Binary) ||
                    (lastTokenType == TokenType.Bracket && lastBracketType == BracketType.Open)) {
                tOp = AllOperators.getOperator(crumb, TokenOperator.OpType.Unary);
                lastOperatorType = TokenOperator.OpType.Unary;
            } else {
                System.out.println("Unknown Operator " + crumb);
            }
            ExpressionItem ei = new ExpressionItem(tOp, TokenType.Operator);
            infix.expr.add(ei);
            lastTokenType = TokenType.Operator;
        } else if (TokenBracket.isBracket(crumb)) {
            if (lastTokenType == TokenType.Constant) {
                TokenConstant tC = new TokenConstant(dnum);
                ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
                infix.expr.add(ei);
                dnum = "";
            }
            TokenBracket tB;
            if (crumb.equals("(")) {
                tB = new TokenBracket(BracketType.Open);
                lastBracketType = BracketType.Open;
            } else {
                tB = new TokenBracket(BracketType.Close);
                lastBracketType = BracketType.Close;
            }
            ExpressionItem ei = new ExpressionItem(tB, TokenType.Bracket);
            infix.expr.add(ei);
            lastTokenType = TokenType.Bracket;
        } else {
            // TODO: Handle variables
            // TODO: Token not matching
            System.out.println("Could not understand " + crumb);
        }
        // TODO: revise this
        return true;
    }

    {
        TokenConstant tC = new TokenConstant(dnum);
        ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
        infix.expr.add(ei);
    }

}