package sort;

import java.util.Arrays;
import java.util.Random;

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
    private int count = 0;
    private int count1 = 0;
    private Random random = new Random();

    private void quickSort(int[] data, int n) {
        quickSortInner(data, 0, n - 1);
    }

    private void quickSortInner(int[] data, int start, int end) {
        count1++;
        if (start >= end) return;
        count++;
        int middle = partition(data, start, end);
        quickSortInner(data, start, middle - 1);
        quickSortInner(data, middle + 1, end);
    }

    private int partition(int[] data, int start, int end) {
//        findMiddle(data, start, end);
        findRandom(data, start, end);
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

    private void findRandom(int[] data, int start, int end) {
        if (start >= end) return;
        int randomIndex = random.nextInt(end - start) + start;
        if (randomIndex != end) {
            swap(data, randomIndex, end);
        }
    }

    private void findMiddle(int[] data, int start, int end) {
        int middleIndex = (start + end) / 2;
        int maxIndex = start;
        int minIndex = end;
        if (data[maxIndex] < data[middleIndex]) {
            maxIndex = middleIndex;
        }
        if (data[maxIndex] < data[end]) {
            maxIndex = end;
        }
        if (data[minIndex] > data[middleIndex]) {
            minIndex = middleIndex;
        }
        if (data[minIndex] > data[end]) {
            minIndex = end;
        }
        middleIndex = start + end + middleIndex - maxIndex - minIndex;
        if (middleIndex != end) {
            swap(data, middleIndex, end);
        }
    }

    private void swap(int[] data, int a, int b) {
        if (a == b) return;
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private void quickSortReverse(int[] data, int n) {
        quickSortInnerReverse(data, 0, n - 1);
    }

    private void quickSortInnerReverse(int[] data, int start, int end) {
        if (start >= end) return;
        int middle = partitionReverse(data, start, end);
        quickSortInnerReverse(data, start, middle - 1);
        quickSortInnerReverse(data, middle + 1, end);
    }

    private int partitionReverse(int[] data, int start, int end) {
        int partition = data[end];
        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (data[j] > partition) {
                swap(data, i, j);
                i++;
            }
        }
        swap(data, i, j);
        System.out.println("start=" + start + " end=" + end + " middle=" + i);
        System.out.println("source: " + Arrays.toString(data));
        System.out.println();
        return i;
    }

    public static void main(String[] args) {
        int[] data = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, data.length);
        System.out.println(Arrays.toString(data));
        System.out.println(quickSort.count);
        System.out.println(quickSort.count1);
        quickSort.quickSortReverse(data, data.length);
        System.out.println(Arrays.toString(data));
//        System.out.println(quickSort.findMaxPosition(data, 7, 0, data.length - 1));
//
//        int[][] value = ArrayCommon.createRandomData();
//        long lastTime = System.currentTimeMillis();
//        for (int i = 0; i < 200; i++) {
//            int[] temp = value[i];
//            quickSort.quickSort(temp, temp.length);
//        }
//        System.out.println("totalTime:\t" + (System.currentTimeMillis() - lastTime));
    }

    private int findMaxPosition(int[] data, int index, int start, int end) {
        System.out.println("--");
        if (index >= data.length) return -1;
        int partition = data[end];
        int i = start, j = start;
        while (j < end) {
            if (data[j] < partition) {
                swap(data, i, j);
                i++;
            }
            j++;
        }
        swap(data, i, j);
        if (index == i) {
            return data[i];
        } else if (index > i) {
            return findMaxPosition(data, index, i + 1, end);
        } else {
            return findMaxPosition(data, index, start, i - 1);
        }
    }
}
