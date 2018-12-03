package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.SelectSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/03
 *     desc   :
 * </pre>
 */

class SelectSort {
    private int count = 0;
    private void selectSort(int[] data, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                count ++;
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 1, 2, 3, 6, 4};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(data, data.length);
        System.out.println("result:\t" + Arrays.toString(data) + "  count:\t" + selectSort.count);
    }
}
