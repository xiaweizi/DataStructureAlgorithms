package search;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : search.BSearch
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/12
 *     desc   :
 * </pre>
 */

class BSearch {

    private int count = 0;

    private int bsearch(int[] data, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            count++;
            int middle = (low + high) / 2;
            if (data[middle] == value) return middle;
            if (data[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BSearch bSearch = new BSearch();
        System.out.println(bSearch.bsearch(data, data.length - 1, 1));
        System.out.println(bSearch.count);
        System.out.println("---------");
        int[] data1 = new int[]{1, 1, 3, 4, 8, 8, 8};
        int index = bSearch.bsearch1(data1, data1.length, 8);
        System.out.println(index);
        System.out.println(data1[index]);
        System.out.println("---------");

        int index1 = bSearch.bsearch2(data1, data1.length, 8);
        System.out.println(index1);
        System.out.println(data1[index1]);
        System.out.println("---------");

        int index2 = bSearch.bsearch3(data1, data1.length, 6);
        System.out.println(index2);
        System.out.println(data1[index2]);
        System.out.println("---------");

        int index3 = bSearch.bsearch4(data1, data1.length, 2);
        System.out.println(index3);
        System.out.println(data1[index3]);
        System.out.println("---------");
    }

    // 1. 查找第一个值等于给定值的元素
    // 2. 查找最后一个值等于给定值的元素
    // 3. 查找第一个大于等于给定值的元素
    // 4. 查找最后一个小于等于给定值的元素

    /**
     * 查找第一个值等于给定值的元素 1,2,3,4,5,5,,6,7
     */
    private int bsearch1(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (data[middle] < value) {
                low = middle + 1;
            } else if (data[middle] > value) {
                high = middle - 1;
            } else {
                if (middle == 0 || data[middle - 1] != value) return middle;
                high--;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素 123455678
     */
    private int bsearch2(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (data[middle] <  value) {
                low = middle + 1;
            } else if (data[middle] > value) {
                high = middle + 1;
            } else {
                if (middle == n - 1 || data[middle + 1] != value) return middle;
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素 1234568910
     */
    private int bsearch3(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (data[middle] >= value) {
                if (middle == 0 || data[middle-1] < value) return middle;
                high = middle - 1;
            } else if (data[middle] < value) {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素 2 5 8 11
     */
    private int bsearch4(int[] data, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (data[middle] <= value) {
                if (middle == n - 1 || data[middle+1] > value) return middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

}
