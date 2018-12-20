package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.BubbleSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/03
 *     desc   :
 * </pre>
 */

class BubbleSort {

    private int count = 0;
    private boolean dataChanged = false;
    private void bubbleSort(int[] data, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            dataChanged = false;
            for (int j = 0; j < n - 1 - i; j++) {
                count ++;
                if (data[j] > data[j + 1]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    dataChanged = true;
                }
            }
            if (!dataChanged) break;
        }
    }

    private void bubbleSortReverse(int[] data, int n) {
        for (int i = 0; i < n - 1; i++) {
            dataChanged = false;
            for (int j = 0; j < n - 1 - i; j++) {
                count ++;
                if (data[j + 1] > data[j]) {
                    dataChanged = true;
                    swap(data, j, j + 1);
                }
            }
            if (!dataChanged) break;
        }
    }

    public static void swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] data = new int[]{1, 2, 3, 5, 6, 4};
        bubbleSort.bubbleSort(data, data.length);
        System.out.println("result:\t" + Arrays.toString(data) + "  count:\t" + bubbleSort.count);
        bubbleSort.count = 0;
        bubbleSort.bubbleSortReverse(data, data.length);
        System.out.println("result:\t" + Arrays.toString(data) + "  count:\t" + bubbleSort.count);

//        int[][] value = ArrayCommon.createRandomData();
//        long lastTime = System.currentTimeMillis();
//        for (int i = 0; i < 200; i++) {
//            int[] temp = value[i];
//            bubbleSort.bubbleSort(temp, temp.length);
//        }
//        System.out.println("totalTime:\t" + (System.currentTimeMillis() - lastTime));
    }
}
