package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.InsertSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/03
 *     desc   :
 * </pre>
 */

class InsertSort {
    private int count = 0;
    private void insertSort(int[] data, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                count++;
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{5, 1, 2, 3, 6, 4};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(data, data.length);
        System.out.println("result:\t" + Arrays.toString(data) + "  count:\t" + insertSort.count);
    }
}
