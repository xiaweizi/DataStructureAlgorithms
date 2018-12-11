package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.QuickSort
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/11
 *     desc   :
 * </pre>
 */

class QuickSort {

    private void quickSort(int[] data, int n) {
        quickSortInner(data, 0, n - 1);
    }

    private void quickSortInner(int[] data, int start, int end) {
        if (start >= end) return;
        int middle = partition(data, start, end);
        quickSortInner(data, start, middle - 1);
        quickSortInner(data, middle + 1, end);
    }

    private int partition(int[] data, int start, int end) {
        int partition = data[end];
        int i = start, j = start;
        while (j <= end - 1) {
            if (data[j] < partition) {
                swap(data, i, j);
                i++;
            }
            j++;
        }
        swap(data, i, j);
//        System.out.println("start="+start+" end="+end+" middle="+i);
//        System.out.println("source: " + Arrays.toString(data));
//        System.out.println();
        return i;
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, data.length);
        System.out.println(Arrays.toString(data));

        int[][] value = ArrayCommon.createRandomData();
        long lastTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            int[] temp = value[i];
            quickSort.quickSort(temp, temp.length);
        }
        System.out.println("totalTime:\t" + (System.currentTimeMillis() - lastTime));
    }
}
