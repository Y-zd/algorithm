package com.yzd.algorithm.linked;

import java.util.Random;

/***
 * @ClassName: GenerateLinkedUtil
 * @Auther: yanzhidong
 * @Date: 2019/4/10 14:36
 * @version : V1.0
 * @Description:
 *
 */
public class GenerateLinkedUtil {

    private static final Random RANDOM = new Random();


    /**
     * 得到从0开始有序的链表
     *
     * @param size
     * @return
     */
    public static Node<Integer> getLinked(int size) {
        Node<Integer> head = new Node(0);
        Node<Integer> temp = head;
        for (int i = 1; i < size; i++) {
            temp.next = new Node<>(i);
            temp = temp.next;
        }
        return head;
    }

    /**
     * 得到随机值有序的链表
     *
     * @param size
     * @return
     */
    public static Node<Integer> getRandomLinked(int size) {
        int factor = RANDOM.nextInt(10);
        Node<Integer> head = new Node(factor);
        Node<Integer> temp = head;
        for (int i = 1; i < size; i++) {
            temp.next = new Node<>(factor + i);
            temp = temp.next;
        }
        return head;
    }

    public static Node<Integer> getRingLinked() {
        Node<Integer> head = new Node(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = new Node<>(6);
        head.next.next.next.next.next.next = new Node<>(7);
        head.next.next.next.next.next.next.next = head;
        return head;
    }


    public static void print(Node head) {
        while (head.next != null) {
            System.out.print(head.item + " —> ");
            head = head.next;
        }
        System.out.println(head.item);
    }


    public static void main(String[] args) {
        System.out.println(RANDOM.nextInt(10));
    }

}
