package com.friedapps.scientycalc.calculator;


import com.friedapps.scientycalc.calculator.ExpressionItem.TokenType;
import com.friedapps.scientycalc.calculator.TokenBracket.BracketType;

import java.util.ArrayList;

public class Tokenizer {

    public static Expression tokenize(ArrayList<String> crumbs) {
        Expression infix = new Expression();

        TokenType lastTokenType = null;
        BracketType lastBracketType = null;
        TokenOperator.OpType lastOperatorType = null;
        String decNumber = "";
        int csize = crumbs.size();
        boolean isDot = false, isNum = false;
        for (int i = 0; i < csize; i++) {
            String currCrumb = crumbs.get(i);
            if (currCrumb.equals(" ")) {
                continue;
            } else if ((isDot = currCrumb.equals(".")) || (isNum = (TokenConstant.getDigit(currCrumb) >= 0))) {
                if (lastTokenType == TokenType.Constant) {
                    if ((isDot && decNumber.indexOf('.') < 0) || isNum) {
                        decNumber += currCrumb;
                    } else {
                        // decimal point already exists
                        // TODO: throw error NumberFormatException
                        System.out.println("Decimal point already exists");
                    }
                } else {
                    decNumber = currCrumb;
                }
                lastTokenType = TokenType.Constant;
            } else if (AllOperators.isOperator(currCrumb)) {
                if (lastTokenType == TokenType.Constant) {
                    TokenConstant tC = new TokenConstant(decNumber);
                    ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
                    infix.expr.add(ei);
                    decNumber = "";
                }
                TokenOperator tOp = null;
                // distinguish between Unary or Binary depending on type of lastOperator or lastBracket
                if (lastTokenType == TokenType.Constant || lastTokenType == TokenType.Variable ||
                        (lastTokenType == TokenType.Bracket && lastBracketType == BracketType.Close)) {
                    tOp = AllOperators.getOperator(currCrumb, TokenOperator.OpType.Binary);
                    lastOperatorType = TokenOperator.OpType.Binary;
                } else if ((lastTokenType == TokenType.Operator && lastOperatorType == TokenOperator.OpType.Binary) ||
                        (lastTokenType == TokenType.Bracket && lastBracketType == BracketType.Open)) {
                    tOp = AllOperators.getOperator(currCrumb, TokenOperator.OpType.Unary);
                    lastOperatorType = TokenOperator.OpType.Unary;
                } else {
                    System.out.println("Unknown Operator " + currCrumb);
                }
                ExpressionItem ei = new ExpressionItem(tOp, TokenType.Operator);
                infix.expr.add(ei);
                lastTokenType = TokenType.Operator;
            } else if (TokenBracket.isBracket(currCrumb)) {
                if (lastTokenType == TokenType.Constant) {
                    TokenConstant tC = new TokenConstant(decNumber);
                    ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
                    infix.expr.add(ei);
                    decNumber = "";
                }
                TokenBracket tB;
                if (currCrumb.equals("(")) {
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
                System.out.println("Could not understand " + currCrumb);
            }
        }
        if (decNumber.length() > 0) {
            TokenConstant tC = new TokenConstant(decNumber);
            ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
            infix.expr.add(ei);
        }
        return infix;
    }

}
