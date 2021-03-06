package stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : stack.ArrayStack
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/14
 *     desc   : 使用数组实现栈
 * </pre>
 */

class ArrayStack<T> implements Iterable<T>{
    private T[] data;
    private int totalCount;
    private int count;

    ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
        totalCount = capacity;
    }

    private boolean push(T t) {
        if (count == totalCount) {
            resize(totalCount * 2);
        }
        data[count] = t;
        count++;
        System.out.println("push: " + t + "  data:\t" + Arrays.toString(data));
        return true;
    }

    private T pop() {
        if (count == 0) return null;
        T t = data[count - 1];
        data[count - 1] = null;
        count --;
        if (count == totalCount / 4 && totalCount / 2 != 0) {
            resize(totalCount / 2);
        }
        System.out.println("pop: " + t + "  data:\t" + Arrays.toString(data));
        return t;
    }

    boolean isEmpty() {
        return count == 0;
    }

    int size() {
        return count;
    }

    T peek() {
        if (count == 0) {
            return null;
        }
        T t = data[count - 1];
        System.out.println("peek: " + t + "  data:\t" + Arrays.toString(data));
        return t;
    }

    private void resize(int newSize) {
        T[] newData = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        totalCount = newData.length;
        System.out.println("扩容前：" + data.length);
        data = newData;
        System.out.println("重新调整大小:\t" + data.length + "  data:\t" + Arrays.toString(data));
    }

    public static void main(String[] args) {
        ArrayStack<Integer> data = new ArrayStack<Integer>(4);
        data.push(1);
        data.push(2);
        data.push(3);
        data.push(4);
        data.push(5);
        data.push(6);
        System.out.println("size:\t" + data.size());
        System.out.println("isEmpty:\t" + data.isEmpty());
        for (Integer datum : data) {
            System.out.print(datum);
        }
        System.out.println();
        data.pop();
        data.pop();
        data.pop();
        data.pop();
        data.peek();
        data.peek();
        data.peek();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
    class ArrayIterator implements Iterator<T> {
        int i = count;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return data[--i];
        }

        @Override
        public void remove() {

        }
    }
}
