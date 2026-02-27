package com.howard.leetcode.calculate;

import java.util.Arrays;

public enum OperatorType {
    PLUS('+'), SUB('-'), MUL('*'), DIV('/'), UNSUPPORTTYPE('\u0000');


    private char symbolStr;

    public void setSymbolStr(char symbolStr) {
        this.symbolStr = symbolStr;
    }

    public char getSymbolStr() {
        return symbolStr;
    }

    private OperatorType(char symbolStr) {
        this.symbolStr = symbolStr;
    }

    public static OperatorType getOperateType(char symbolStrType) {
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.getSymbolStr() == symbolStrType)
                .findFirst().orElse(OperatorType.UNSUPPORTTYPE);


    }

}
