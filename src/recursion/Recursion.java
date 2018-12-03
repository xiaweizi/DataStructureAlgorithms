package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : recursion.Recursion
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/03
 *     desc   : 递归代码测试
 * </pre>
 */

class Recursion {

    private Map<Integer, Integer> cached = new HashMap<Integer, Integer>();
    private int count = 0;

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println("电影座位:--递归--\t" + recursion.findPosition(10));
        System.out.println("电影座位:--迭代--\t" + recursion.findPositionNormal(10));
        recursion.count = 0;
        System.out.println("台阶多少种走法:--递归--\t" + recursion.findLadder(10) + "  count:\t" + recursion.count);
        System.out.println("台阶多少种走法:--迭代--\t" + recursion.findLadderNormal(10));
        recursion.count = 0;
        System.out.println("台阶多少种走法:--升级--\t" + recursion.findLadderAdvanced(10) + "  count:\t" + recursion.count);
    }

    private int findPosition(int n) {
        if (n == 1) return 1;
        return findPosition(n - 1) + 1;
    }

    private int findLadder(int n) {
        count ++;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return findLadder(n - 1) + findLadder(n - 2);
    }

    private int findLadderAdvanced(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        System.out.println("++");
        if (cached.containsKey(n)) {
            System.out.println("--");
            return cached.get(n);
        }
        System.out.println("==");
        count ++;
        int result = findLadderAdvanced(n - 1) + findLadderAdvanced(n - 2);
        cached.put(n, result);
        return result;
    }

    private int findPositionNormal(int n) {
        int position = 0;
        for (int i = 0; i < n - 1; i++) {
            position += 1;
        }
        return position;
    }

    private int findLadderNormal(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = 0;
        int pre1 = 1;
        int pre2 =2;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

}
