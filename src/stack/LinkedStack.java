package stack;

import common.Node;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : stack.LinkedStack
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/15
 *     desc   :
 * </pre>
 */

class LinkedStack<T> {
    Node<T> head = null;

    void push(T t) {
        Node<T> node = createNode(t);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        System.out.println("push:\t" + t + "  data:\t" + head.toString());
    }

    T pop() {
        if (head == null) {
            return null;
        }
        T t = head.value;
        head = head.next;
        if (head != null) {
            System.out.println("pop:\t" + t + "  data:\t" + head.toString());
        } else {
            System.out.println("pop:\t" + t + "  data:\tnull");
        }
        return t;
    }

    Node<T> createNode(T t) {
        return new Node<T>(t, null);
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
