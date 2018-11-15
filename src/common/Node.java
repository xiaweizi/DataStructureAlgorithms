package common;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.common.Node
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/15
 *     desc   :
 * </pre>
 */

public class Node<T> {
    public Node<T> next;
    public T value;

    public Node(T t, Node next) {
        this.value = t;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node head = this;
        while (head != null) {
            sb.append(head.value.toString()).append(" ");
            head = head.next;
        }
        return sb.toString();
    }
}
