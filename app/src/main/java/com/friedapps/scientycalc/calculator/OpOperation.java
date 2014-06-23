package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.calculator.TokenOperator.OpType;

public abstract class OpOperation {

    public abstract TokenConstant calcBinary(TokenConstant opL, TokenConstant opR);

    public abstract TokenConstant calcUnary(TokenConstant op);

}
