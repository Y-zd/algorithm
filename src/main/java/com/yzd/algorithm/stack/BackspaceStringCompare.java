package com.yzd.algorithm.stack;

import java.util.Stack;

/***
 * @ClassName: BackspaceStringCompare
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:50
 * @version : V1.0
 * @Description:
 *      给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *示例 1：
 *      输入：S = “ab#c”, T = “ad#c”
 *      输出：true
 *      解释：S 和 T 都会变成 “ac”。
 *示例 2：
 *      输入：S = “ab##”, T = “c#d#”
 *      输出：true
 *      解释：S 和 T 都会变成 “”。
 *示例 3：
 *      输入：S = “a##c”, T = “#a#c”
 *      输出：true
 *      解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *      输入：S = “a#c”, T = “b”
 *      输出：false
 *      解释：S 会变成 “c”，但 T 仍然是 “b”
 */
public class BackspaceStringCompare {


    public static Stack<Character> getCharStack(String str) {
        Stack<Character> stack = new Stack();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack;
    }

    public static boolean compare(String str1, String str2) {
        Stack<Character> charStack = getCharStack(str1);
        Stack<Character> charStack2 = getCharStack(str2);
        if (charStack.size() != charStack2.size()) {
            return false;
        }
        for (int i = 0; i < charStack.size(); i++) {
            Character pop1 = charStack.pop();
            Character pop2 = charStack2.pop();
            if (!pop1.equals(pop2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compare("ab#c", "ad#c"));
        System.out.println(compare("ab##", "c#d#"));
        System.out.println(compare("a##c", "a#c"));
        System.out.println(compare("a#c", "b"));

    }

}
