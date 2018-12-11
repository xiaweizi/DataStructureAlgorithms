package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.CountSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/11
 *     desc   :
 * </pre>
 */

class CountSort {
    private void countSort(int[] data, int n) {
        int max = data[0];
        for (int i = 1; i < n; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        int[] temp = new int[max + 1];
        for (int i = 0; i < n; i++) {
            temp[data[i]]++;
        }

        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i - 1] + temp[i];
        }

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int index = --temp[data[i]];
            result[index] = data[i];
        }
        for (int i = 0; i < n; i++) {
            data[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        CountSort countSort = new CountSort();
        countSort.countSort(data, data.length);
        System.out.println(Arrays.toString(data));

        int[][] value = ArrayCommon.createRandomData();
        long lastTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            int[] temp = value[i];
            countSort.countSort(temp, temp.length);
        }
        System.out.println("totalTime:\t" + (System.currentTimeMillis() - lastTime));
    }
}
