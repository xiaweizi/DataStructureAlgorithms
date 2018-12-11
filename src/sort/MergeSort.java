package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.MergeSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/10
 *     desc   :
 * </pre>
 */

class MergeSort {

    private void mergeSort(int[] data, int n) {
        mergeSortInner(data, 0, n - 1);
    }

    private void mergeSortInner(int[] data, int a, int b) {
        if (a >= b) return;
        int middle = (a + b) / 2;
        mergeSortInner(data, a, middle);
        mergeSortInner(data, middle + 1, b);
        mergeData(data, a, middle, b);
    }

    private static void mergeData(int[] data, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= middle && j <= end) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        int start1 = i;
        int end1 = middle;
        if (j <= end) {
            start1 = j;
            end1 = end;
        }
        while (start1 <= end1) {
            temp[k++] = data[start1++];
        }
        for (int l = 0; l <= end - start; l++) {
            data[start + l] = temp[l];
        }
    }

    private void mergeData1(int[] data, int start, int middle, int end) {

        int[] temp = new int[data.length + 2];
        int index = 0;
        for (int i = start; i <= middle; i++) {
            temp[index++] = data[i];
        }
        temp[index++] = Integer.MAX_VALUE;
        for (int i = middle + 1; i <= end; i++) {
            temp[index++] = data[i];
        }
        temp[index] = Integer.MAX_VALUE;
        int i = 0;
        int j = middle - start + 2;
        int k = start;
        while (temp[i] != Integer.MAX_VALUE || temp[j] != Integer.MAX_VALUE) {
            if (temp[i] < temp[j]) {
                data[k++] = temp[i++];
            } else {
                data[k++] = temp[j++];
            }
        }
//        System.out.println(Arrays.toString(temp));
//        System.out.println("start="+start+" middle="+middle+" end="+end);
//        System.out.println(Arrays.toString(data));
//        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(data, data.length);
        System.out.println(Arrays.toString(data));

        long lastTime = System.currentTimeMillis();
        int[][] value = ArrayCommon.createRandomData();
        for (int i = 0; i < 200; i++) {
            int[] temp = value[i];
            mergeSort.mergeSort(temp, temp.length);
        }
        System.out.println("totalTime:\t" + (System.currentTimeMillis() - lastTime));
    }
}
