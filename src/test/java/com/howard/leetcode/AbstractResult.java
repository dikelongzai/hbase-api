package com.howard.leetcode;

public abstract class AbstractResult {
    private int resultCode;
    private final String returnMsg;
    private final Object returnObj;

    protected AbstractResult(int resultCode, String returnMsg, Object returnObj) {
        this.resultCode = resultCode;
        this.returnMsg = returnMsg;
        this.returnObj = returnObj;
    }
}
