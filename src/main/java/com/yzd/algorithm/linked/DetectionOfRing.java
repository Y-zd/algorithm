package com.yzd.algorithm.linked;

import java.util.HashSet;

/***
 * @ClassName: DetectionOfRing
 * @Auther: yanzhidong
 * @Date: 2019/4/10 14:31
 * @version : V1.0
 * @Description: 链表中环的检测
 *
 * 时间复杂度与内存复杂度比较两种方法。快慢指针法的时间复杂度更高，内存复杂度更低
 */
public class DetectionOfRing {


    /**
     * 方法1：
     * 足迹法
     *
     * @param head
     * @return
     */
    public static boolean detect1(Node head) {
        HashSet keySet = new HashSet();
        for (; head.next != null; head = head.next) {
            boolean has = keySet.contains(head);
            if (has) {
                System.out.println(head.item);
                return true;
            }
            keySet.add(head);
        }
        return false;
    }

    /**
     * 方法2：
     * 快慢指针,一个走一步，一个走两步
     * 遍历链表，如果走到最后节点没相遇则没环，有相遇则有环
     *
     * @param head
     * @return
     */
    public static boolean detect2(Node head) {
        Node slow = head;
        if (slow == null) {
            return false;
        }
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                System.out.println(slow.item);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }


    public static void main(String[] args) {
        Node<Integer> linked = GenerateLinkedUtil.getRingLinked();
        System.out.println("方法1:" + detect1(linked));
        System.out.println("方法2:" + detect2(linked));
    }

}
