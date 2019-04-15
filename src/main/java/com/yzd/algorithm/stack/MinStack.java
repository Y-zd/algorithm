package com.yzd.algorithm.stack;

import com.yzd.algorithm.linked.Node;

import java.util.Random;

/***
 * @ClassName: MinStack
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:49
 * @version : V1.0
 * @Description:
 *      设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *      push(x) -- 将元素 x 推入栈中。
 *      pop() -- 删除栈顶的元素。
 *      top() -- 获取栈顶元素。
 *      getMin() -- 检索栈中的最小元素。
 *
 * 使用链栈，实现基本的入栈出栈，遍历栈中元素，同时比较其值，取其中最小，最后返回最小值。
 */
public class MinStack {

    private Node<Integer> head;

    MinStack() {
        this.head = null;
    }


    public void push(int e) {
        if (head == null) {
            head = new Node<>(e);
        } else {
            Node newHead = new Node(e);
            newHead.next = head;
            head = newHead;
        }
    }

    public int pop() throws Exception {
        if (head == null) {
            throw new Exception("栈为空");
        }
        int temp = head.item;
        head = head.next;
        return temp;

    }

    public int top() throws Exception {
        if (head == null) {
            throw new Exception("栈为空");
        }
        return head.item;
    }

    public int getMin() throws Exception {
        if (head == null) {
            throw new Exception("栈为空");
        }

        int temp = head.item;

        while (head.next != null) {
            int nextValue = head.next.item;
            if (temp > nextValue) {
                temp = nextValue;
            }
            head = head.next;
        }
        return temp;
    }

}

class Test {
    public static void main(String[] args) throws Exception {

        Random random = new Random();

        MinStack minStack = new MinStack();

        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(20);
            System.out.print(value + "  ");
            minStack.push(value);
        }
        System.out.println("栈顶元素: " + minStack.top());
        System.out.println("出栈: " + minStack.pop());
        System.out.println("栈中最小元素: " + minStack.getMin());

    }
}