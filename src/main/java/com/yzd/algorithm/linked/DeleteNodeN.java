package com.yzd.algorithm.linked;

import java.util.List;

/***
 * @ClassName: DeleteNodeN
 * @Auther: yanzhidong
 * @Date: 2019/4/10 17:16
 * @version : V1.0
 * @Description: 删除链表倒数第n个结点
 *
 */
public class DeleteNodeN {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param index
     * @return
     */
    public static Node delete(Node head, int index) {
        Node now = head;
        while (now.next != null) {
            Node temp = now;
            for (int i = 0; i < index; i++) {
                if (temp == null) {
                    System.out.println("越界啦");
                    return head;
                }
                temp = temp.next;
            }
            //倒数n个节点为头节点
            if (temp == null) {
                Node newHead = head.next;
                head.next = null;
                return newHead;
            }
            if (temp.next == null) {
                now.next = now.next.next;
                break;
            }
            now = now.next;
        }
        return head;
    }


    public static void main(String[] args) {
        System.out.println("删除前:");
        Node<Integer> linked = GenerateLinkedUtil.getLinked(5);
        GenerateLinkedUtil.print(linked);
        System.out.println("删除后:");
        GenerateLinkedUtil.print(delete(linked, 1));

    }

}
