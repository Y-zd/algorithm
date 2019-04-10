package com.yzd.algorithm.linked;

/***
 * @ClassName: Node
 * @Auther: yanzhidong
 * @Date: 2019/4/9 15:53
 * @version : V1.0
 * @Description: 链表节点
 *
 *   单链表反转
 *
 *   链表中环的检测
 *
 *   两个有序的链表合并
 *
 *   删除链表倒数第 n 个结点
 *
 *   求链表的中间结点
 *
 */
public class Node<E> {

    E item;
    Node<E> next;

    Node(E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }

    public Node() {
    }

    public Node(E item) {
        this.item = item;
    }
}
