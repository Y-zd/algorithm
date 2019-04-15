package com.yzd.algorithm.stack;

import java.util.Random;
import java.util.Stack;

/***
 * @ClassName: ImplementQueueUsingStacks
 * @Auther: yanzhidong
 * @Date: 2019/4/12 15:50
 * @version : V1.0
 * @Description:
 *      使用栈实现队列的下列操作：
 *      push(x) -- 将一个元素放入队列的尾部。
 *      pop() -- 从队列首部移除元素。
 *      peek() -- 返回队列首部的元素。
 *      empty() -- 返回队列是否为空。
 *思路：
 *      用两个栈来实现
 *      将队列中的元素 “abcd” 压入 stack1 中，此时 stack2 为空；
 *      将 stack1 中的元素 pop 进 stack2 中，此时 pop 一下 stack2 中的元素，就可以达到和队列删除数据一样的顺序了；
 */
public class ImplementQueueUsingStacks<E> {

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();


    public E push(E e) {
        stack1.push(e);
        return e;
    }

    public E pop() {
        if (stack2.empty()) {
            //将stack1的数据全部压入stack2
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public E peek() {
        if (stack2.empty()) {
            //将stack1的数据全部压入stack2
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}

class ImplementQueueUsingStacksTest {

    public static void main(String[] args) {

        Random random = new Random();
        ImplementQueueUsingStacks implementQueueUsingStacks = new ImplementQueueUsingStacks();
        System.out.println("队列是否为空: " + implementQueueUsingStacks.empty());
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10);
            System.out.print(i1 + " ");
            implementQueueUsingStacks.push(i1);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println("peek: " + implementQueueUsingStacks.peek());
            System.out.println("pop: " + implementQueueUsingStacks.pop());
        }
        for (int i = 0; i < 5; i++) {
            int i1 = random.nextInt(10);
            System.out.print(i1 + " ");
            implementQueueUsingStacks.push(i1);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("peek: " + implementQueueUsingStacks.peek());
            System.out.println("pop: " + implementQueueUsingStacks.pop());
        }

    }

}
