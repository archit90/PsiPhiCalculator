package com.friedapps.scientycalc.calculator;

public abstract class OpOperation {

    public abstract TokenConstant calcBinary(TokenConstant opL, TokenConstant opR);

    public abstract TokenConstant calcUnary(TokenConstant op);

}
