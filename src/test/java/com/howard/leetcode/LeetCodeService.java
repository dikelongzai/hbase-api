package com.howard.leetcode;

public interface LeetCodeService<IN>{
    boolean validParam(IN in);
    Object executeService(IN in);
    Object execute(IN in);
}
