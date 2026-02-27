package com.howard.leetcode.calculate.bistack;

import com.sun.istack.NotNull;

import java.util.HashMap;
import java.util.Stack;

public class BiStackCalculate {
    final private HashMap<Character, Integer> mapOperators = new HashMap<Character, Integer>();

    public BiStackCalculate() {
        initMapOperators();
    }

    private void initMapOperators() {
        mapOperators.put('+', 1);
        mapOperators.put('-', 1);
        mapOperators.put('*', 2);
        mapOperators.put('/', 2);
    }

    public int calculate(String express) {
        int result = 0;
        Stack<Character> ops = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        numbers.push(Integer.valueOf(0));
        for (int startIndex = 0; startIndex < express.length(); startIndex++) {
            Character charCurrent  = express.charAt(startIndex);
            if (charCurrent == '(') {
                ops.push(charCurrent);
            } else if (charCurrent == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    calculateSingleBiStack(ops, numbers);
                }
                ops.pop();//pop element (
            } else if (Character.isDigit(charCurrent)) {
                int tempNum = 0;
                int numLastIndex = startIndex;
                while (numLastIndex < express.length() && Character.isDigit(express.charAt(numLastIndex))) {
                    tempNum = tempNum * 10 + (express.charAt(numLastIndex++) - '0');
                }
                startIndex = numLastIndex - 1;
                numbers.push(tempNum);
            } else  {
                //+ - * /
                if(startIndex>0&&express.charAt(startIndex-1)=='('){
                    numbers.push(0);
                }
                while (!ops.isEmpty()&&ops.peek()!='('){
                    Character prevOps=ops.peek();
                    if(mapOperators.get(prevOps)> mapOperators.get(charCurrent)){
                        calculateSingleBiStack(ops,numbers);
                    }else {
                        break;
                    }
                }
                ops.push(charCurrent);
            }

        }
        while (!ops.isEmpty()&&!numbers.isEmpty()){
            calculateSingleBiStack(ops,numbers);
        }
        return numbers.peek();
    }

    public void calculateSingleBiStack(@NotNull Stack<Character> ops, Stack<Integer> numbers) {
        if (numbers.size() < 2 || ops.isEmpty()) return;
        int result = 0;
        Character opsChar = ops.pop();
        Integer input1 = numbers.pop(), input2 = numbers.pop();
        switch (opsChar) {
            case '+':
                result = input1 + input2;
                break;
            case '-':
                result = input1 - input2;
                break;
            case '*':
                result = input1 * input2;
                break;
            case '/':
                result = input1 / input2;
                break;
            default:


        }
        numbers.push(result);
    }
}
