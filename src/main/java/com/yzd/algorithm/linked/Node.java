package com.yzd.algorithm.linked;

/***
 * @ClassName: Node
 * @Auther: yanzhidong
 * @Date: 2019/4/11 15:39
 * @version : V1.0
 * @Description: 链表节点
 *
 */
public class Node<E> {

    E item;
    com.yzd.algorithm.linked.Node<E> next;

    Node(E element, com.yzd.algorithm.linked.Node<E> next) {
        this.item = element;
        this.next = next;
    }

    public Node() {
    }

    public Node(E item) {
        this.item = item;
    }
}
