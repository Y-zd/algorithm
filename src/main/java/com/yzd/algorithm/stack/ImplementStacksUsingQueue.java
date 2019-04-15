package com.yzd.algorithm.stack;


import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/***
 * @ClassName: ImplementStacksUsingQueue
 * @Auther: yanzhidong
 * @Date: 2019/4/15 14:37
 * @version : V1.0
 * @Description:
 *      用队列实现栈
 * 思路：
 *      当栈里面插入元素 “abcd” 的时候，元素 a 在栈底（最后出去），d 在栈顶（最先出去）
 *      将元素 “abc” 从 queue1 中头删，然后再 queue2 中尾插进来之后，头删 queue1 中的元素“d”，就相当于实现了栈顶元素的出栈
 *      同理，将元素 “ab” 从 queue2 中头删，然后尾插到 queue1 中，然后再头删 queue2 中的元素“c”;
 */
public class ImplementStacksUsingQueue<E> {

    private Queue<E> queue1;
    private Queue<E> queue2;
    private int size;

    public ImplementStacksUsingQueue(int size) {
        this.size = size;
        this.queue1 = new ArrayBlockingQueue<E>(size);
        this.queue2 = new ArrayBlockingQueue<E>(size);
    }


    public E push(E e) throws Exception {
        if (!queue1.isEmpty()) {
            if (queue1.size() == size) {
                throw new Exception("栈已满");
            }
            queue1.add(e);
        } else {
            if (queue2.size() == size) {
                throw new Exception("栈已满");
            }
            queue2.add(e);
        }
        return e;
    }

    public E pop() throws Exception {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new Exception("栈为空");
        }
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        } else {
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }

    public E peek() throws Exception {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new Exception("栈为空");
        }
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.add(queue2.remove());
            }
            E peek = queue2.peek();
            queue1.add(queue2.remove());
            return peek;
        } else {
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }
            E peek = queue1.peek();
            queue2.add(queue1.remove());
            return peek;
        }
    }

}

class ImplementStacksUsingQueueTest {

    public static void main(String[] args) throws Exception{
        ImplementStacksUsingQueue implementStacksUsingQueue = new ImplementStacksUsingQueue(15);


        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10);
            System.out.print(i1 + " ");
            implementStacksUsingQueue.push(i1);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println("peek: " + implementStacksUsingQueue.peek());
            System.out.println("pop: " + implementStacksUsingQueue.pop());
        }
        for (int i = 0; i < 5; i++) {
            int i1 = random.nextInt(10);
            System.out.print(i1 + " ");
            implementStacksUsingQueue.push(i1);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("peek: " + implementStacksUsingQueue.peek());
            System.out.println("pop: " + implementStacksUsingQueue.pop());
        }

    }
}
