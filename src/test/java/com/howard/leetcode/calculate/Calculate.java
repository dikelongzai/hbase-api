package com.howard.leetcode.calculate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class Calculate {
    private static final Logger logger = LoggerFactory.getLogger(Calculate.class);
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';
    private int idx;

    public int calculate(String inputStr) {
        idx = 0;

        int result= 0;
        try {
            result = calc(inputStr).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Number calc(String str) throws Exception {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
//        priorityQueue.add()
        //sign is recorded an temporary Sign
        //res is recorded an complete calculation
        //num is recorded incomplete number
        Number res = 0, num = 0;
        char lastSign = OperatorType.PLUS.getSymbolStr();
        while (idx < str.length()) {
            char c = str.charAt(idx++);
            if (c >= '0' && c <= '9') num = num.doubleValue() * 10 + c - '0';
            else if (c == LEFT_BRACKET)
                // ( is start of a new sub-problem, Let recursion solve the sub-problem
                num = calc(str);
            else if (c == RIGHT_BRACKET) return getOpeatorResult(res, num, lastSign);

            else if (OperatorType.getOperateType(c) != OperatorType.UNSUPPORTTYPE) { // only when we meet a new sign, we know a while number has been read
                res = getOpeatorResult(res, num, lastSign);
                num = 0;
                lastSign = c;
            }

        }
        return getOpeatorResult(res, num, lastSign).intValue();
    }

    private Number getOpeatorResult(Number res, Number num, char lastSign) throws Exception {
        return Opeate.execute(new Opeate(res, num, lastSign)).intValue();
    }

    /**
     * 合法性检测
     *
     * @param inputStr
     * @return
     */
    public boolean valid(String inputStr) {

        return false;
    }


    public static class Opeate<IN1 extends Number, IN2 extends Number> {
        public IN1 getIn1() throws Exception {
            if (in1 != null) {
                return in1;
            } else {
                if (this.leftOpeate != null) {
                    return (IN1) executeOpeate(this.leftOpeate);
                } else {
                    return null;
                }

            }
        }

        public IN2 getIn2() throws Exception {
            if (in2 != null) {
                return in2;
            } else {
                if (this.leftOpeate != null) {
                    return (IN2) executeOpeate(this.rightOpeate);
                } else {
                    return null;
                }

            }
        }

        public void setIn1(IN1 in1) {
            this.in1 = in1;
        }


        public void setIn2(IN2 in2) {
            this.in2 = in2;
        }

        private IN1 in1;
        private IN2 in2;
        private char operatorType;
        private Opeate leftOpeate;

        public Opeate getRightOpeate() {
            return rightOpeate;
        }

        public void setRightOpeate(Opeate rightOpeate) {
            this.rightOpeate = rightOpeate;
        }

        private Opeate rightOpeate;

        public Opeate(IN1 in, IN2 in2, char operatorType) {
            this.in1 = in;
            this.in2 = in2;
            this.operatorType = operatorType;
        }

        public Opeate(Opeate leftOpeate, IN2 in2, char operatorType) {
            this.leftOpeate = leftOpeate;
            this.in2 = in2;
            this.operatorType = operatorType;
        }

        public Opeate(Opeate leftOpeate, Opeate rightOpeate, char operatorType) {
            this.rightOpeate = rightOpeate;
            this.leftOpeate = leftOpeate;
            this.operatorType = operatorType;
        }

        public static Number execute(Opeate opeate) throws Exception {
            return executeOpeate(opeate);

        }

        private static Number executeOpeate(Opeate opeate) throws Exception {
            OperatorType operatorType = OperatorType.getOperateType(opeate.operatorType);
            switch (operatorType) {
                case PLUS:
                    return opeate.getIn1().doubleValue() + opeate.getIn2().doubleValue();
                case SUB:
                    return opeate.getIn1().doubleValue() - opeate.getIn2().doubleValue();
                case MUL:
                    return opeate.getIn1().doubleValue() * opeate.getIn2().doubleValue();
                case DIV:
                    return opeate.getIn1().doubleValue() / opeate.getIn2().doubleValue();

            }
            return 0;
        }

    }


}
