package com.yzd.algorithm.linked;

/***
 * @ClassName: MiddleNode
 * @Auther: yanzhidong
 * @Date: 2019/4/11 11:28
 * @version : V1.0
 * @Description:
 *    求链表的中间节点
 *
 */
public class MiddleNode {

    public static void main(String[] args) {
        System.out.println("原链表:");
        Node<Integer> linked = GenerateLinkedUtil.getLinked(8);
        GenerateLinkedUtil.print(linked);
        System.out.println("中间节点:" + getMiddle(linked).item);
    }

    /**
     * 快慢指针
     * 一个走一步，一个走两步
     * 两步的走到null则一步的在中间节点
     *
     * @param head
     * @return
     */
    public static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        int count = 1;
        while (fast != null && fast.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                System.out.println("链表长度为奇数");
            }

        }
        System.out.println("步数:" + count);
        return slow;
    }


}
