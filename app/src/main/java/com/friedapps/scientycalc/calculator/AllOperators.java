package com.friedapps.scientycalc.calculator;

import java.util.HashMap;
import java.util.Map;

public class AllOperators {
    private static final Map<TokenOperator.Op, TokenOperator> allOps = new HashMap<TokenOperator.Op, TokenOperator>();

    static {

        allOps.put(TokenOperator.Op.Add, new TokenOperator(TokenOperator.Op.Add, "+", 550, TokenOperator.OpAssoc.Left, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Subtract, new TokenOperator(TokenOperator.Op.Subtract, "-", 550, TokenOperator.OpAssoc.Left, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Multiply, new TokenOperator(TokenOperator.Op.Multiply, "*", 600, TokenOperator.OpAssoc.Left, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Divide, new TokenOperator(TokenOperator.Op.Divide, "/", 600, TokenOperator.OpAssoc.Left, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Modulus, new TokenOperator(TokenOperator.Op.Modulus, "%", 600, TokenOperator.OpAssoc.Left, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Exponent, new TokenOperator(TokenOperator.Op.Exponent, "^", 650, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Binary));
        allOps.put(TokenOperator.Op.Plus, new TokenOperator(TokenOperator.Op.Plus, "+", 1000, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Minus, new TokenOperator(TokenOperator.Op.Minus, "-", 1000, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Sin, new TokenOperator(TokenOperator.Op.Sin, "Sin", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Cos, new TokenOperator(TokenOperator.Op.Cos, "Cos", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Tan, new TokenOperator(TokenOperator.Op.Tan, "Tan", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Cosec, new TokenOperator(TokenOperator.Op.Cosec, "Cosec", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Sec, new TokenOperator(TokenOperator.Op.Sec, "Sec", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Cot, new TokenOperator(TokenOperator.Op.Cot, "Cot", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
        allOps.put(TokenOperator.Op.Log, new TokenOperator(TokenOperator.Op.Log, "Log", 800, TokenOperator.OpAssoc.Right, TokenOperator.OpType.Unary));
    }

    public static TokenOperator getOperator(TokenOperator.Op op) {
        return allOps.get(op);
    }

    /*
    public static TokenOperator getOperator(String op) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            String sym = item.getValue().getSymbol();
            if (sym.equals(op)) {
                return item.getValue();
            }
        }
        return null;
    }
    */

    public static TokenOperator getOperator(String op, TokenOperator.OpType opType) {
        for (Map.Entry<TokenOperator.Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator to = item.getValue();
            String sym = to.getSymbol();
            if (to.getType() == opType && sym.equals(op)) {
                return item.getValue();
            }
        }
        return null;
    }

    public static boolean isOperator(String op) {
        for (Map.Entry<TokenOperator.Op, TokenOperator> item : allOps.entrySet()) {
            String sym = item.getValue().getSymbol();
            if (sym.equals(op)) {
                return true;
            }
        }
        return false;
    }

}
