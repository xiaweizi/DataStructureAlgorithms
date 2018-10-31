package array;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : array.GenericArray
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/10/31
 *     desc   :
 * </pre>
 */

class GenericArray<T> {
    T[] data;
    int size;

    GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    GenericArray() {
        this(10);
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    void resize(int newSize) {
        T[] newData = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        System.out.println("扩容 capacity:\t" + newSize);
        data = newData;
    }

    T get(int index) {
        checkIndex(index);
        return data[index];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void set(int index, T t) {
        checkIndex(index);
        data[index] = t;
        System.out.println("set value:" + " index: " + index + " value: " + t);
        System.out.println("data: " + toString());
    }

    int getCapacity() {
        return data.length;
    }

    int getCount() {
        return size;
    }

    boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                return true;
            }
        }
        return false;
    }

    int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                return i;
            }
        }
        return -1;
    }

    void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = t;
        size ++;
        System.out.println("add data: " + " index: " + index + " value: " + t);
        System.out.println("data: " + toString());
    }

    void addFirst(T t) {
        add(0, t);
    }

    void addLast(T t) {
        add(size, t);
    }

    T remove(int index) {
        checkIndex(index);
        T t = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size-1] = null;
        size--;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        System.out.println("remove data: " + " index: " + index + " value: " + t);
        System.out.println("data: " + toString());
        return t;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        GenericArray<String> data = new GenericArray<String>(6);
        data.addLast("1");
        data.addLast("2");
        data.addLast("3");
        data.addLast("4");
        data.addLast("5");
        data.addLast("6");
        data.addLast("7");

        data.remove(data.getCount()-1);
        data.remove(data.getCount()-1);
        data.remove(data.getCount()-1);
        data.remove(data.getCount()-1);


    }
}
