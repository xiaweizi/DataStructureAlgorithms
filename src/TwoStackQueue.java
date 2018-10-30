import java.util.Stack;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.TwoStackQueue
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/07/24
 *     desc   : 两个栈实现队列
 *              1. 无论 StackA 要往 StackB 中压入元素，那么必须选择一次性全部亚茹
 *              2. 无论什么时候从队列中取元素，必须保证元素是从 StackB 中 pop 出，也就是说，当 StackB 不为空的时候决不能再次向 StackB 中压入元素
 * </pre>
 */

class TwoStackQueue<E> {
    private Stack<E> stackA;
    private Stack<E> stackB;

    public TwoStackQueue() {
        stackA = new Stack<E>();
        stackB = new Stack<E>();
    }

    public boolean add(E e) {
        stackA.add(e);
        return true;
    }

    public E poll() {
        if (stackB.isEmpty() && stackA.isEmpty()) {
            return null;
        }
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.add(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public E peek() {
        if (stackB.isEmpty() && stackA.isEmpty()) {
            return null;
        }
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.add(stackA.pop());
            }
        }
        return stackB.peek();
    }

    public boolean isEmpty() {
        return stackB.isEmpty() && stackA.isEmpty();
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        System.out.println(queue.poll());
        queue.add(10);
        System.out.println(queue.poll());
    }

}
