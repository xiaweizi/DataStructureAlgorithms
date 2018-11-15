package stack;

import java.util.Iterator;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : stack.StackTest1
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/15
 *     desc   :
 * </pre>
 */

class StackTest1 {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("[");
        stack.push("{");
        stack.push("『");
        stack.push("「");
        stack.push("」");
        stack.push("』");
        stack.push("}");
        stack.push("]");
        System.out.println(stack.toString());
        System.out.println("is correct:\t" + isCorrect(stack));
    }

    private static boolean isCorrect(LinkedStack<String> stack) {
        boolean isCorrect = true;
        LinkedStack<String> stack1 = new LinkedStack<String>();
        for (String s : stack) {
            stack1.push(s);
        }
        Iterator<String> iterator = stack.iterator();
        Iterator<String> iterator1 = stack1.iterator();
        while (iterator.hasNext() && iterator1.hasNext()) {
            if (!equals(iterator.next(), iterator1.next())) {
                return false;
            }
        }
        return isCorrect;
    }

    private static boolean equals(String one, String two) {
        return ("[".equals(one) && "]".equals(two)) || ("[".equals(two) && "]".equals(one)) ||
                ("{".equals(one) && "}".equals(two)) || ("{".equals(two) && "}".equals(one)) ||
                ("「".equals(one) && "」".equals(two)) || ("「".equals(two) && "」".equals(one)) ||
                ("『".equals(one) && "』".equals(two)) || ("『".equals(two) && "』".equals(one));
    }
}
