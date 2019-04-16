package com.yzd.algorithm.stack;

import java.util.Stack;

/***
 * @ClassName: BaseballGame
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:50
 * @version : V1.0
 * @Description:
 *      你现在是棒球比赛记录员。
 *      给定一个字符串列表，每个字符串可以是以下四种类型之一：
 *      1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 *      2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 *      3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 *      4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *      每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 *      你需要返回你在所有回合中得分的总和。
 *例1：
 *      输入： [“5”，“2”，“C”，“D”，“+”]
 *      输出： 30
 *  说明：
 *      第1轮：你可以获得5分。总和是：5。
 *      第2轮：你可以获得2分。总和是：7。
 *      操作1：第2轮的数据无效。总和是：5。
 *      第3轮：你可以获得10分（第2轮的数据已被删除）。总和是：15。
 *      第4轮：你可以获得5 + 10 = 15分。总和是：30。
 *例2：
 *      输入： [“5”，“ -  2”，“4”，“C”，“D”，“9”，“+”，“+”]
 *      输出： 27
 *  说明：
 *      第1轮：你可以获得5分。总和是：5。
 *      第2轮：你可以获得-2分。总和是：3。
 *      第3轮：你可以获得4分。总和是：7。
 *      操作1：第3轮的数据无效。总和是：3。
 *      第4轮：你可以得到-4分（第3轮的数据已被删除）。总和是：-1。
 *      第5轮：你可以获得9分。总和是：8。
 *      第6轮：你可以获得-4 + 9 = 5分。总和是13。
 *      第7轮：你可以获得9 + 5 = 14分。总和是27。
 */
public class BaseballGame {

    public static int sum(String str) {
        String[] split = str.split(",");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (isNum(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                if (s.equals("+")) {
                    //最近一轮
                    Integer top1 = stack.pop();
                    Integer top2 = stack.pop();
                    int now = top1 + top2;
                    stack.push(top2);
                    stack.push(top1);
                    stack.push(now);
                }
                if (s.equals("D")) {
                    Integer top = stack.peek();
                    stack.push(top * 2);
                }
                if (s.equals("C")) {
                    stack.pop();
                }
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;

    }

    public static boolean isNum(String str) {
        if (str.equals("+") || str.equals("D") || str.equals("C")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sum("5,2,C,D,+") == 30);
        System.out.println(sum("5,-2,4,C,D,9,+,+") == 27);

    }

}
