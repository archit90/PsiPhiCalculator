package com.friedapps.scificalc.calculator;

import com.friedapps.scificalc.ButtonKeys;
import com.friedapps.scificalc.calculator.TokenOperator.Op;
import com.friedapps.scificalc.calculator.TokenOperator.OpAssoc;
import com.friedapps.scificalc.calculator.TokenOperator.OpKind;
import com.friedapps.scificalc.calculator.TokenOperator.OpType;

import java.util.HashMap;
import java.util.Map;

public class AllOperators {
    private static final Map<Op, TokenOperator> allOps = new HashMap<Op, TokenOperator>();

    static {

        allOps.put(Op.Add, new TokenOperator(Op.Add, ButtonKeys.Key.kAdd, 550, OpAssoc.Left, OpType.Binary, OpKind.infix));
        allOps.put(Op.Subtract, new TokenOperator(Op.Subtract, ButtonKeys.Key.kSubt, 550, OpAssoc.Left, OpType.Binary, OpKind.infix));
        allOps.put(Op.Multiply, new TokenOperator(Op.Multiply, ButtonKeys.Key.kMul, 600, OpAssoc.Left, OpType.Binary, OpKind.infix));
        allOps.put(Op.Divide, new TokenOperator(Op.Divide, ButtonKeys.Key.kDiv, 600, OpAssoc.Left, OpType.Binary, OpKind.infix));
        allOps.put(Op.Modulus, new TokenOperator(Op.Modulus, ButtonKeys.Key.kMod, 600, OpAssoc.Left, OpType.Binary, OpKind.infix));
        allOps.put(Op.Exponent, new TokenOperator(Op.Exponent, ButtonKeys.Key.kExp, 650, OpAssoc.Right, OpType.Binary, OpKind.infix));
        allOps.put(Op.Minus, new TokenOperator(Op.Minus, ButtonKeys.Key.kPlusMinus, 1000, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Sin, new TokenOperator(Op.Sin, ButtonKeys.Key.kSin, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Cos, new TokenOperator(Op.Cos, ButtonKeys.Key.kCos, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Tan, new TokenOperator(Op.Tan, ButtonKeys.Key.kTan, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Log10, new TokenOperator(Op.Log10, ButtonKeys.Key.kLog10, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Ln, new TokenOperator(Op.Ln, ButtonKeys.Key.kLn, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
        allOps.put(Op.Log2, new TokenOperator(Op.Log2, ButtonKeys.Key.kLog2, 800, OpAssoc.Right, OpType.Unary, OpKind.prefix));
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
        allOperations.put(Op.Log10, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.log10(op.val));
            }
        });
        allOperations.put(Op.Ln, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.log(op.val));
            }
        });
        allOperations.put(Op.Log2, new OpOperation() {
            @Override
            public TokenConstant calcBinary(TokenConstant opL, TokenConstant opR) {
                return null;
            }

            @Override
            public TokenConstant calcUnary(TokenConstant op) {
                return new TokenConstant(Math.log(op.val) / Math.log(2));
            }
        });

    }

    public static OpOperation getOpOperation(Op op) {
        return allOperations.get(op);
    }

    public static TokenOperator getOperator(Op op) {
        return allOps.get(op);
    }

    public static TokenOperator getOperator(ButtonKeys.Key op, OpType opType) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator to = item.getValue();
            if (to.getType() == opType && to.getKey() == op) {
                return item.getValue();
            }
        }
        return null;
    }

    public static TokenOperator getOperator(ButtonKeys.Key op) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator to = item.getValue();
            if (to.getKey() == op) {
                return item.getValue();
            }
        }
        return null;
    }

    public static boolean isOperator(ButtonKeys.Key k) {
        for (Map.Entry<Op, TokenOperator> item : allOps.entrySet()) {
            TokenOperator tOp = item.getValue();
            if (tOp.getKey() == k)
                return true;
        }
        return false;
    }
}
