package com.yzd.algorithm.stack;

import java.util.Stack;

/***
 * @ClassName: BasicCalculator
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:49
 * @version : V1.0
 * @Description:
 *      实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *      字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格。
 * 思路：
 *      用一个栈放数，一个栈放运算符
 */
public class BasicCalculator {

    public static int calculat(String str) {
        int temp = 0;
        Stack<Integer> valueStack = new Stack();
        Stack<Character> signsStack = new Stack();
        char[] chars = str.toCharArray();

        //用于记录连续的数
        String tempValue = "";

        StringBuffer stringBuffer = new StringBuffer();

        //12+(1-1)
        for (int i = 0; i < chars.length; i++) {
            Character aChar = chars[i];
            if (!aChar.equals(' ')) {
                if (aChar != '+' && aChar != '-' && aChar != '(' && aChar != ')') {
                    tempValue += aChar;
                    if (i == chars.length - 1) {
                        valueStack.push(Integer.valueOf(tempValue));
                    }
                } else {
                    if (!tempValue.isEmpty()) {
                        valueStack.push(Integer.valueOf(tempValue));
                        tempValue = "";
                    }
                    if (valueStack.size() > 1) {
                        Character pop = signsStack.pop();
                        Integer pop1 = valueStack.pop();
                        Integer pop2 = valueStack.pop();
                        if (pop.equals('+')) {
                            valueStack.push(pop1 + pop2);
                        } else {
                            valueStack.push(pop2 - pop1);
                        }
                    }
                    if (aChar.equals(')')) {
                        signsStack.pop();
                    } else {
                        signsStack.push(aChar);
                    }

                }
            }
        }
        if (valueStack.size() > 1) {
            Character pop = signsStack.pop();
            Integer pop1 = valueStack.pop();
            Integer pop2 = valueStack.pop();
            if (pop.equals('+')) {
                valueStack.push(pop1 + pop2);
            } else {
                valueStack.push(pop2 - pop1);
            }
        }
        return valueStack.peek();

    }

    public static void main(String[] args) {
        System.out.println(calculat("(12-13+12)"));
    }

}
