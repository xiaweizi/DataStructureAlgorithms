import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.TwoQueueStack
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/07/24
 *     desc   : 两个队列实现栈
 *              1. 任何时候两个队列总有一个是空的
 *              2. 添加元素总是向非空队列中添加元素
 *              3. 取出元素的时候总是将元素除队尾最后一个元素外，导入另一空队列中，最后一个元素出队
 * </pre>
 */

class TwoQueueStack<E> {
    private Queue<E> queueA;
    private Queue<E> queueB;

    public TwoQueueStack() {
        queueA = new LinkedList<E>();
        queueB = new LinkedList<E>();
    }

    E push(E e) {
        if (!queueA.isEmpty()) {
            System.out.println("从 A 入队 " + e);
            queueA.add(e);
        } else if (!queueB.isEmpty()) {
            System.out.println("从 B 入队 " + e);
            queueB.add(e);
        } else {
            System.out.println("从 A 入队 " + e);
            queueA.add(e);
        }
        return e;
    }

    E pop() {
        if (queueA.isEmpty() && queueB.isEmpty()) {
            return null;
        }
        E e = null;
        if (!queueA.isEmpty()) {
            while (queueA.size() > 0) {
                e = queueA.poll();
                if (!queueA.isEmpty()) {
                    System.out.println("从 A 出队 进入 B " + e);
                    queueB.add(e);
                }
            }
            System.out.println("从 A 出队 " + e);
        } else {
            while (queueB.size() > 0) {
                e = queueB.poll();
                if (!queueB.isEmpty()) {
                    System.out.println("从 B 出队进入 A " + e);
                    queueA.add(e);
                }
            }
            System.out.println("从 B 出队 " + e);
        }
        return e;
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> queueStack = new TwoQueueStack<Integer>();
        for (int i = 0; i < 5; i++) {
            queueStack.push(i);
        }
        System.out.println(queueStack.pop());
        queueStack.push(12);
        System.out.println(queueStack.pop());
    }
}
