package test.dd;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/3 
 * @version : V1.0
 *
 */
public class Node {

    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
