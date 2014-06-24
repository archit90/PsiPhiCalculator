package com.friedapps.scientycalc.calculator;


import android.util.Log;

import com.friedapps.scientycalc.calculator.ButtonKeys.Keys;
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

    public boolean addToken(Keys crumb) {
        // TODO: implement ctr
        boolean isDot = false, isNum = false;
        int num = 0;
        if (crumb == Keys.kAns && dnum.length() > 0) {
            TokenConstant tC = new TokenConstant(dnum);
            ExpressionItem ei = new ExpressionItem(tC, TokenType.Constant);
            infix.expr.add(ei);
            // TODO: Evaluate answer
        } else if ((isDot = crumb == Keys.kDot) ||
                (isNum = ((num = TokenConstant.getDigit(crumb)) >= 0))) {
            if (lastTokenType == TokenType.Constant) {
                if ((isDot && dnum.indexOf('.') < 0) || isNum) {
                    dnum += num;
                } else {
                    // decimal point already exists
                    // TODO: throw error NumberFormatException
                    Log.d("Calc", "Decimal point already exists");
                    return false;
                }
            } else {
                dnum = "" + TokenConstant.getDigit(crumb);
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
                tOp = AllOperators.getOperator(crumb, OpType.Binary);
                lastOperatorType = TokenOperator.OpType.Binary;
            } else if ((lastTokenType == TokenType.Operator && lastOperatorType == TokenOperator.OpType.Binary) ||
                    (lastTokenType == TokenType.Bracket && lastBracketType == BracketType.Open)) {
                tOp = AllOperators.getOperator(crumb, OpType.Unary);
                lastOperatorType = TokenOperator.OpType.Unary;
            } else {
                Log.d("Calc", "Unknown Operator " + crumb);
                return false;
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
            if (crumb == Keys.kBrOpen) {
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
            Log.d("Calc", "Could not understand " + crumb);
        }
        // TODO: revise this
        return true;
    }

}