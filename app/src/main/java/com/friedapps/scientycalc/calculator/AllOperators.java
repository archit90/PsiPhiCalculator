package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.calculator.ButtonKeys.Keys;
import com.friedapps.scientycalc.calculator.TokenOperator.Op;
import com.friedapps.scientycalc.calculator.TokenOperator.OpAssoc;
import com.friedapps.scientycalc.calculator.TokenOperator.OpType;

import java.util.HashMap;
import java.util.Map;

public class AllOperators {
    private static final Map<Op, TokenOperator> allOps = new HashMap<Op, TokenOperator>();

    static {

        allOps.put(Op.Add, new TokenOperator(Op.Add, Keys.kAdd, 550, OpAssoc.Left, OpType.Binary));
        allOps.put(Op.Subtract, new TokenOperator(Op.Subtract, Keys.kSubt, 550, OpAssoc.Left, OpType.Binary));
        allOps.put(Op.Multiply, new TokenOperator(Op.Multiply, Keys.kMul, 600, OpAssoc.Left, OpType.Binary));
        allOps.put(Op.Divide, new TokenOperator(Op.Divide, Keys.kDiv, 600, OpAssoc.Left, OpType.Binary));
        allOps.put(Op.Modulus, new TokenOperator(Op.Modulus, Keys.kMod, 600, OpAssoc.Left, OpType.Binary));
        allOps.put(Op.Exponent, new TokenOperator(Op.Exponent, Keys.kExp, 650, OpAssoc.Right, OpType.Binary));
        allOps.put(Op.Minus, new TokenOperator(Op.Minus, Keys.kPlusMinus, 1000, OpAssoc.Right, OpType.Unary));
        allOps.put(Op.Sin, new TokenOperator(Op.Sin, Keys.kSin, 800, OpAssoc.Right, OpType.Unary));
        allOps.put(Op.Cos, new TokenOperator(Op.Cos, Keys.kCos, 800, OpAssoc.Right, OpType.Unary));
        allOps.put(Op.Tan, new TokenOperator(Op.Tan, Keys.kTan, 800, OpAssoc.Right, OpType.Unary));
        allOps.put(Op.Log, new TokenOperator(Op.Log, Keys.kLog, 800, OpAssoc.Right, OpType.Unary));
    }

    private static final Map<Op, OpOperation> allOperations = new HashMap<Op, OpOperation>();

    static {
        allOperations.put(Op.Add, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(opL.val + opR.val);
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Subtract, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(opL.val - opR.val);
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Multiply, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(opL.val * opR.val);
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Divide, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(opL.val / opR.val);
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Exponent, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(Math.pow(opL.val, opR.val));
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Modulus, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return new TokenConstant(opL.val % opR.val);
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return null;
            }
        });
        allOperations.put(Op.Minus, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(-op.val);
            }
        });
        allOperations.put(Op.Sin, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.sin(op.val));
            }
        });
        allOperations.put(Op.Cos, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.cos(op.val));
            }
        });
        allOperations.put(Op.Tan, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.tan(op.val));
            }
        });

    }

    public static OpOperation getOpOperation(Op op) {
        return allOperations.get(op);
    }

    public static TokenOperator getOperator(Op op) {
        return allOps.get(op);
    }

    public static TokenOperator getOperator(Keys op, OpType opType) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator to = item.getValue();
            if (to.getType() == opType && to.getKey() == op) {
                return item.getValue();
            }
        }
        return null;
    }

    public static boolean isOperator(Keys k) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator tOp = item.getValue();
            if (tOp.getKey() == k)
                return true;
        }
        return false;
    }
}
