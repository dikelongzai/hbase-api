package com.howard.leetcode;

import java.io.Serializable;

public abstract class LeetCodeServiceImp<IN> implements LeetCodeService<IN>, Serializable {

    public static final String msgFail="param err";

    public IN getInput() {
        return input;
    }

    private final IN input;

    public LeetCodeServiceImp(final IN in) {
        this.input = in;
    }
    public Object execute() {
      boolean validResult=this.validParam(input);
      if(validResult){
          return this.executeService(input);
      }else {
          return msgFail;
      }
    }


}
