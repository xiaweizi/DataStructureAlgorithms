package queue;

import common.Node;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : queue.LinkedQueue
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/01
 *     desc   :
 * </pre>
 */

class LinkedQueue<T> {
    Node<T> head = null;
    Node<T> tail = null;

    void enqueue(T t) {
        if (tail == null) {
            Node<T> node = new Node<T>(t, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node<T>(t, null);
            tail = tail.next;
        }
        System.out.println(head.toString());
    }

    T dequeue() {
        if (head == null) return null;
        T t = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        System.out.println(head == null ? "null" : head.toString());
        return t;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.dequeue();
    }
}
