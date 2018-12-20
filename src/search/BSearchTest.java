package search;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : search.BSearchTest
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/20
 *     desc   :
 * </pre>
 */

class BSearchTest {

    public static void main(String[] args) {
        BSearchTest bSearchTest = new BSearchTest();
        int[] data = new int[]{7, 6, 5, 4, 3, 2, 1};
        int result1 = bSearchTest.bsearch1(data, data.length, 2);
        System.out.println("---- 查找等于给定值的元素 ----");
        System.out.println("index: " + result1 + " value: " + data[result1]);

        int[] data1 = new int[]{7, 6, 6, 5, 5, 3, 3, 3, 2, 1, 1, 1};
        int result2 = bSearchTest.bsearch2(data1, data1.length, 6);
        System.out.println("---- 查找第一个值等于给定值的元素 ----");
        System.out.println("index: " + result2 + " value: " + data1[result2]);

        int result3 = bSearchTest.bsearch3(data1, data1.length, 3);
        System.out.println("---- 查找最后一个值等于给定值的元素 ----");
        System.out.println("index: " + result3 + " value: " + data1[result3]);

        int result4 = bSearchTest.bsearch4(data1, data1.length, 5);
        System.out.println("---- 查找第一个小于等于给定值的元素 ----");
        System.out.println("index: " + result4 + " value: " + data1[result4]);

        int result5 = bSearchTest.bsearch5(data1, data1.length, 4);
        System.out.println("---- 查找最后一个大于等于给定值的元素 ----");
        System.out.println("index: " + result5 + " value: " + data1[result5]);

    }

    /**
     * 5 4 3 2 1
     */
    private int bsearch1(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (data[middle] > value) {
                low = middle + 1;
            } else if (data[middle] < value) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素 5,4,3,3,2,1
     */
    private int bsearch2(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (data[middle] > value) {
                low = middle + 1;
            } else if (data[middle] < value) {
                high = middle - 1;
            } else {
                if (middle == 0 || data[middle - 1] != value) return middle;
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素 5,4,3,3,2,1
     */
    private int bsearch3(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (data[middle] > value) {
                low = middle + 1;
            } else if (data[middle] < value) {
                high = middle - 1;
            } else {
                if (middle == n - 1 || data[middle + 1] != value) return middle;
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个小于等于给定值的元素 5,4,3,3,2,1
     */
    private int bsearch4(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (data[middle] > value) {
                low = middle + 1;
            } else if (data[middle] <= value) {
                if (middle == 0 || data[middle - 1] > value) return middle;
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个大于等于给定值的元素
     */
    private int bsearch5(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (data[middle] < value) {
                high = middle - 1;
            } else {
                if (middle == n - 1 || data[middle + 1] < value) return middle;
                low = middle + 1;
            }
        }
        return -1;
    }
}
