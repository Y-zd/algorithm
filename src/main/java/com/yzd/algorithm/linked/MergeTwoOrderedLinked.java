package com.yzd.algorithm.linked;

/***
 * @ClassName: MergeTwoOrderedLinked
 * @Auther: yanzhidong
 * @Date: 2019/4/10 15:42
 * @version : V1.0
 * @Description: 两个有序的链表合并
 *
 */
public class MergeTwoOrderedLinked {


    /**
     * 1 3 5 7 9
     * 2 4 6 8 10
     * 1.先比较头节点的大小，小的为新链表的头节点
     *
     * @param linked1
     * @param linked2
     * @return
     */
    public static Node merge(Node<Integer> linked1, Node<Integer> linked2) {

        Node newLinked;
        if (linked1.item < linked2.item) {
            newLinked = linked1;
            linked1 = linked1.next;
        } else {
            newLinked = linked2;
            linked2 = linked2.next;
        }
        Node now = newLinked;
        while (linked1 != null && linked2 != null) {
            if (linked1.item < linked2.item) {
                now.next = linked1;
                linked1 = linked1.next;
            } else {
                now.next = linked2;
                linked2 = linked2.next;
            }
            now = now.next;
            if (linked1 == null) {
                now.next = linked2;
            }
            if (linked2 == null) {
                now.next = linked1;
            }
        }
        return newLinked;
    }

    public static void main(String[] args) {
        System.out.println("有序链表1:");
        Node<Integer> randomLinked1 = GenerateLinkedUtil.getRandomLinked(5);
        GenerateLinkedUtil.print(randomLinked1);
        System.out.println("有序链表2:");
        Node<Integer> randomLinked2 = GenerateLinkedUtil.getRandomLinked(5);
        GenerateLinkedUtil.print(randomLinked2);
        System.out.println("合并后:");
        GenerateLinkedUtil.print(merge(randomLinked1, randomLinked2));
    }
}
