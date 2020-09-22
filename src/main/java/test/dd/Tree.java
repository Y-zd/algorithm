package test.dd;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/3 
 * @version : V1.0
 *
 */
public class Tree {


    /**
     *    10
     *  7    12
     * 5   8
     *
     * @param args
     */
    public static void main(String[] args) {
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        Node node5 = new Node(5);
        Node node8 = new Node(8);
        Node node12 = new Node(12);
        node10.left = node7;
        node10.right = node12;
        node7.left = node5;
        node7.right = node8;
        System.out.println(find(node10, 1));
    }
    public static Node find(Node node, int value) {
        if (node == null || node.value == value) {
            return node;
        }
        if (node.value > value) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }


}
