package com.yzd.algorithm.stack;

import java.util.*;

/***
 * @ClassName: ValidParentheses
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:46
 * @version : V1.0
 * @Description:
 *      给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *      有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      注意空字符串可被认为是有效字符串。
 *
 */
public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(valid("[2((1)){}]"));
    }


    public static boolean valid(String string) {
        Map<Character, Character> keyMap = new HashMap();
        keyMap.put('(', ')');
        keyMap.put('{', '}');
        keyMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (keyMap.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (checkright(aChar)) {
                    Character peek = stack.peek();
                    if (keyMap.get(peek).equals(aChar)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }

        }
        return stack.size() == 0;
    }

    public static boolean checkright(Character character) {
        if (character.equals(']') || character.equals(')') || character.equals('}')) {
            return true;
        } else {
            return false;
        }
    }




}
