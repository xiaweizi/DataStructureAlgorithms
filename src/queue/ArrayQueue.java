package queue;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : queue.ArrayQueue
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/29
 *     desc   : 使用数组实现队列
 * </pre>
 */

class ArrayQueue<T> {
    T[] items;
    int head;
    int tail;
    int count;

    ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        count = capacity;
    }

    boolean enqueue(T t) {
        if (tail == count) return false;
        items[tail] = t;
        tail ++;
        print("enqueue");
        return true;
    }

    T dequeue() {
        if (head == tail) return null;
        T t= items[head];
        items[head] = null;
        head ++;
        print("dequeue");
        return t;
    }

    void print(String mode) {
        System.out.println("mode:\t" + mode + " head:\t" + head + " tail:\t" + tail);
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<String>(8);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");
    }
}
