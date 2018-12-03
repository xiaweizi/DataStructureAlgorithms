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

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] data = new int[]{5, 1, 2, 3, 4, 6};
        bubbleSort.bubbleSort(data, data.length);
        System.out.println("result:\t" + Arrays.toString(data) + "  count:\t" + bubbleSort.count);
    }
}
