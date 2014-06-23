package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.calculator.TokenOperator.OpType;

public abstract class OpOperation {
    public OpType type;

    public abstract ExpressionItem calcBinary(ExpressionItem opL, ExpressionItem opR);

    public abstract ExpressionItem calcUnary(ExpressionItem op);

}
