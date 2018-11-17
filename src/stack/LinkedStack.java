package stack;

import java.util.Iterator;

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

class LinkedStack<T> implements Iterable<T> {
    Node<T> head = null;
    int count = 0;

    void push(T t) {
        Node<T> node = createNode(t);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        count++;
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
        count--;
        return t;
    }

    boolean isEmpty() {
        return count == 0;
    }

    int size() {
        return count;
    }

    T peek() {
        if (head == null) {
            return null;
        }
        T t = head.value;
        System.out.println("peek:\t" + t + "  data:\t" + head.toString());
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
        System.out.println("size:\t" + stack.size());
        System.out.println("isEmpty:\t" + stack.isEmpty());
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        stack.peek();
        stack.peek();
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    void clear() {
        head = null;
        count = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    class LinkedIterator implements Iterator<T> {
        Node<T> first = head;
        int n = count;

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public T next() {
            T t = first.value;
            first = first.next;
            n--;
            return t;
        }

        @Override
        public void remove() {

        }
    }
}
