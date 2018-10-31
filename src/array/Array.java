package array;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : array.Array
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/10/30
 *     desc   : 自定义数组，不支持扩容
 * </pre>
 */

class Array {
    int data[];
    int count;
    int n;

    Array(int capacity) {
        data = new int[capacity];
        count = 0;
        n = capacity;
    }

    boolean add(int index, int value) {
        if (count >= n) {
            System.out.println("容量达到最大值");
            return false;
        }
        if (index > count) {
            System.out.println("下标越界");
            return false;
        }
        // 从屁股开始，往后移动，将 index 位置空出来
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        System.out.println("插入成功:\tvalue:\t" + value + ":\tindex:\t" + index);
        System.out.println("data:\t" + toString());
        return true;
    }

    int get(int index) {
        if (index >= count) {
            return -1;
        }
        System.out.println("value:\t" + data[index]);
        return data[index];
    }

    boolean delete(int index) {
        if (index >= count) {
            System.out.println("下标越界");
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = 0;
        count--;
        System.out.println("删除成功 data:\t" + toString());
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.add(0, 1);
        array.add(1, 2);
        array.add(2, 3);
        array.add(3, 4);
        array.add(4, 5);
        array.add(5, 6);
        array.add(6, 7);
        array.add(7, 8);
        array.add(8,9);
        array.add(9,10);
        array.delete(9);
        System.out.println("get value:\t" + array.get(3));
    }
}
