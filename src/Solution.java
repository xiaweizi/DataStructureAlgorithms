import java.util.Stack;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.Solution
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/07/25
 *     desc   :
 * </pre>
 */

class Solution {
    /**
     *
     * push 入栈的同时，维护一个从 0 递增的下标，如果 pop[index] == push.peek()，push.pop()，并且
     * index ++,一直到入栈结束，如果栈已经 pop 完，则证明出栈顺序 == 入栈顺序
     */
    private static boolean isPopOrder(int[] push, int[] pop) {
        int length = push.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex ++) {
            stack.push(push[pushIndex]);
            while (!stack.isEmpty() && popIndex < length && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{6,7,2,5,1,4,3};
        int[] popA = new int[]{6,5,2,1,7,3,4};
        System.out.println(isPopOrder(push, popA));
    }
}
