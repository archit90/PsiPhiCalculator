package com.friedapps.scientycalc.calculator;


import java.util.ArrayList;

public class Expression {
    public ArrayList<ExpressionItem> list;

    public Expression() {
        list = new ArrayList<ExpressionItem>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ExpressionItem ei : list) {
            sb.append(ei.toString()).append(" ");
        }
        return sb.toString();
    }
}
