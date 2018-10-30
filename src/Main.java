public class Main {

    public static void main(String[] args) {
        System.out.println(isOdd(4));
        System.out.println(log2(9));
        System.out.println(count1(7));
        System.out.println(count2(7));

        int[] nums = new int[]{2,2,3,4,4,4,3,4,5, 1};
        System.out.println(oldTimeNum(nums));
        printOddTimesNum(nums);
    }

    private static boolean isOdd(int num){
        return (num & 1) != 0;
    }

    private static boolean log2(int num) {
        return (num & (num - 1)) == 0;
    }
    private static int count1(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }

    private static int count2(int n) {
        int result = 0;
        while (n != 0) {
            // 和自己小一的数相 & 1 会少一个
            n &= (n - 1);
            result ++ ;
        }
        return result;
    }

    private static int oldTimeNum(int[] nums) {
        int e0 = 0;
        for (int num : nums) {
            e0 ^= num;
        }
        return e0;
    }

    public static void printOddTimesNum(int[] arr) {
        int eO = 0;
        int eOhasOne = 0;

        for (int cur : arr) {
            eO = eO ^ cur;
        }
        System.out.println("e0 " + eO);

        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((rightOne & cur) != 0) {
                eOhasOne = eOhasOne ^ cur;
            }
        }
        System.out.println("eOhasOne = " + eOhasOne + "  " + (eOhasOne ^ eO));
    }


}
