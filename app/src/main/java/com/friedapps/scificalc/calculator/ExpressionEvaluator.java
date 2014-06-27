package com.friedapps.scificalc.calculator;

import java.util.Stack;

public class ExpressionEvaluator {

    public static Expression infixToPostfix(Expression infix) {
        Expression rpn = new Expression();
        Stack<ExpressionItem> opStack = new Stack<ExpressionItem>();
        for (ExpressionItem item : infix.list) {
            switch (item.type) {
                case Constant:
                    rpn.list.add(item);
                    break;
                case Operator:
                    TokenOperator tOp = (TokenOperator) item.token;
                    TokenOperator tStk;
                    while (!opStack.empty()) {
                        ExpressionItem eiStk = opStack.peek();
                        if (eiStk.type == ExpressionItem.TokenType.Bracket) {
                            break;
                        } else {
                            tStk = (TokenOperator) eiStk.token;
                            if ((tOp.getAssoc() == TokenOperator.OpAssoc.Left && TokenOperator.comparePrecedence(tOp, tStk) <= 0) ||
                                    (tOp.getAssoc() == TokenOperator.OpAssoc.Right && TokenOperator.comparePrecedence(tOp, tStk) < 0)) {
                                rpn.list.add(opStack.pop());
                            } else break;
                        }
                    }
                    opStack.push(item);
                    break;
                case Bracket:
                    TokenBracket tB = (TokenBracket) item.token;
                    if (tB.type == TokenBracket.BracketType.Open)
                        opStack.push(item);
                    else {
                        while (true) {
                            ExpressionItem chk = opStack.peek();
                            if (chk.type == ExpressionItem.TokenType.Bracket && ((TokenBracket) chk.token).type == TokenBracket.BracketType.Open) {
                                opStack.pop();
                                break;
                            } else {
                                rpn.list.add(opStack.pop());
                            }
                        }
                    }
                    break;
                default:
            }
        }
        while (!opStack.empty()) {
            ExpressionItem item = opStack.pop();
            if (item.type != ExpressionItem.TokenType.Bracket) {
                rpn.list.add(item);
            } else {
                // TODO: throw error, mismatch parens
            }
        }


        return rpn;
    }

    public static ExpressionItem evaluateExpression(Expression rpn) {
        Stack<TokenConstant> operands = new Stack<TokenConstant>();
        TokenConstant tC;
        TokenVariable tV;
        TokenOperator tOp;
        for (ExpressionItem item : rpn.list) {

            switch (item.type) {
                case Bracket:
                    // TODO: throw error, not a valid postfix
                    System.out.println("Bracket!!");
                    return null;
                case Operator:
                    tOp = (TokenOperator) item.token;
                    TokenConstant t1, t2, tres;
                    switch (tOp.getType()) {
                        case Unary:
                            t1 = operands.pop();
                            tres = AllOperators.getOpOperation(tOp.getVal()).calcUnary(t1);
                            operands.push(tres);
                            break;
                        case Binary:
                            t2 = operands.pop();
                            t1 = operands.pop();
                            tres = AllOperators.getOpOperation(tOp.getVal()).calcBinary(t1, t2);
                            operands.push(tres);
                            break;
                    }
                    break;
                case Constant:
                    tC = (TokenConstant) item.token;
                    operands.push(tC);
                    break;
                case Variable:
                    tV = (TokenVariable) item.token;
                    tC = new TokenConstant(tV.val);
                    operands.push(tC);
                    break;

            }
        }
        ExpressionItem eres = null;
        if (operands.size() == 1) {
            TokenConstant tres = operands.pop();
            eres = new ExpressionItem(tres, ExpressionItem.TokenType.Constant);
        }

        return eres;
    }
}
