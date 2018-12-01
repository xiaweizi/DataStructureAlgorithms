package queue;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : queue.DynamicArrayQueue
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/01
 *     desc   : 动态调整数组的位置队列
 * </pre>
 */

class DynamicArrayQueue<T> {
    T[] items;
    int head;
    int tail;
    int count;

    DynamicArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        count = capacity;
    }

    boolean enqueue(T t) {
        if (tail == count) {
            if (head == 0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = t;
        tail ++;
        print("enqueue");
        return true;
    }

    T dequeue() {
        if (head == tail) return null;
        T t = items[head];
        items[head] = null;
        head ++;
        print("new dequeue");
        return t;
    }

    void print(String mode) {
        System.out.println("mode:\t" + mode + " head:\t" + head + " tail:\t" + tail);
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + "");
        }
        System.out.println();
        System.out.println(Arrays.toString(items));
    }

    public static void main(String[] args) {
        DynamicArrayQueue<String> queue = new DynamicArrayQueue<String>(6);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
    }
}
