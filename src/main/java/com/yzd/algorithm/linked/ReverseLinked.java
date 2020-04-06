package com.yzd.algorithm.linked;


/***
 * @ClassName: ReverseLinked
 * @Auther: yanzhidong
 * @Date: 2019/4/9 15:53
 * @version : V1.0
 * @Description: 单链表的反转
 *
 */
public class ReverseLinked {

    public static void main(String[] args) {
        System.out.println("反转前:");
        GenerateLinkedUtil.print(GenerateLinkedUtil.getLinked(5));
        System.out.println("迭代法反转后:");
        GenerateLinkedUtil.print(reverse(GenerateLinkedUtil.getLinked(5)));
        System.out.println("递归法1反转后:");
        GenerateLinkedUtil.print(recursionReverse1(GenerateLinkedUtil.getLinked(5), null));
        System.out.println("递归法2反转后:");
        GenerateLinkedUtil.print(recursionReverse2(GenerateLinkedUtil.getLinked(5)));
    }


    /**
     * 1.迭代法：
     * 先将下一节点纪录下来，然后让当前节点指向上一节点，
     * 再将当前节点纪录下来,再让下一节点变为当前节点
     * 操作如下：
     * 1->2->3->4
     * 1<-2  3->4
     * 1<-2<-3  4
     * 1<-2<-3<-4
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node now = head;
        while (now != null) {
            Node next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }


    /**
     * 2.递归方法1：
     * 先找到最后一个节点，然后从最后一个开始反转,
     * 然后当前节点反转时其后面的节点已经进行反转了，不需要管。
     * 最后返回原来的最后一个节点
     *
     * @param node
     * @return
     * @Param prev
     */
    public static Node recursionReverse1(Node node, Node prev) {

        if (node.next == null) {
            node.next = prev;
            return node;
        } else {
            Node re = recursionReverse1(node.next, node);
            node.next = prev;
            return re;
        }
    }

    /**
     * 3.递归方法2：
     * 先找到最后一个节点，
     * 然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,
     * 然后当前节点反转时其后面的节点已经进行反转了，不需要管。
     * 最后返回原来的最后一个节点。
     *
     * @param node
     * @return
     */
    public static Node recursionReverse2(Node node) {
        if (node.next == null) {
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node re = recursionReverse2(next);
        next.next = node;
        return re;

    }


}
