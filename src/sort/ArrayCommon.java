package sort;

import java.util.Random;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : sort.ArrayCommon
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/12/03
 *     desc   :
 * </pre>
 */

public class ArrayCommon {

    public static int[][] createRandomData(int count, int perNum) {
        int[][] data = new int[count][perNum];
        Random random = new Random();
        for (int j = 0; j < count; j++) {
            for (int i = 0; i < perNum; i++) {
                data[j][i] = (int) (random.nextDouble() * 1000);
            }
        }
        return data;
    }
}
