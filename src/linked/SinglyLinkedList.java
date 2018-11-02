package linked;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : linked.SinglyLinkedList
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/10/31
 *     desc   :
 * </pre>
 */

class SinglyLinkedList {

    private Node head = null;

    void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        System.out.println("insert head " + node.value + " data:\t" + toString());
    }

    void insertToHead(int value) {
        insertToHead(createNode(value));
    }

    void insertAfter(Node node, Node newNode) {
        if (node == null) return;
        newNode.next = node.next;
        node.next = newNode;
        System.out.println("insertAfter data:\t" + toString());
    }

    void insertAfter(Node node, int value) {
        insertAfter(node, createNode(value));
    }

    void insertBefore(Node before, Node newNode) {
        if (before == null) return;
        if (head == before) {
            insertToHead(newNode);
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != before) {
            // 直到找打 before 的上个节点
            temp = temp.next;
        }
        newNode.next = before;
        temp.next = newNode;
        System.out.println("insertBefore data:\t" + toString());
    }

    void insertBefore(Node before, int value) {
        insertBefore(before, createNode(value));
    }

    Node findByValue(int value) {
        Node temp = head;
        while (temp != null && temp.value != value) {
            temp = temp.next;
        }
        return temp;
    }

    Node findByIndex(int index) {
        Node temp = head;
        int pos = 0;
        while (temp != null && pos != index) {
            temp = temp.next;
            pos++;
        }
        return temp;
    }

    void insertLast(Node node) {
        if (head == null) {
            head = node;
            System.out.println("insert last " + node.value + " data:\t" + toString());
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        System.out.println("insert last " + node.value + " data:\t" + toString());
    }

    void insertLast(int value) {
        insertLast(createNode(value));
    }

    private Node createNode(int value) {
        return new Node(null, value);
    }

    void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        Node before = null;
        Node current = head;
        while (current != null && current.value != value) {
            before = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        if (before == null) {
            head = head.next;
        } else {
            before.next = current.next;
        }
        System.out.println("deleteByValue:\t" + toString());
    }

    void deleteByNode(Node node) {
        if (head == null || node == null) {
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }
        temp.next = node.next;
        System.out.println("deleteByNode:\t" + toString());
    }


    @Override
    public String toString() {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (temp != null) {
            sb.append(temp.value).append(",");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    static class Node {
        int value;
        Node next;

        Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        int getData() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        void print() {
            Node temp = this;
            while (temp != null) {
                System.out.print(temp.value + "");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
//        linkedList.insertLast(1);
//        linkedList.insertLast(2);
//        linkedList.insertLast(3);
//        linkedList.insertLast(4);
//        linkedList.insertToHead(5);
//        linkedList.insertAfter(linkedList.findByValue(3), 6);
//        linkedList.insertBefore(linkedList.findByValue(1), 7);
//
//        linkedList.deleteByValue(2);
//        linkedList.deleteByNode(linkedList.findByValue(1));

//        linkedList.insertLast(1);
//        linkedList.insertLast(2);
//        linkedList.insertLast(2);
//        linkedList.insertLast(1);
//        System.out.println("是否为回文函数:\t" + linkedList.isPalindrome());
//        System.out.println("--------------------");
//        Node node = new Node(null, 4);
//        Node node1 = new Node(node, 3);
//        Node node2 = new Node(node1, 2);
//        Node node3 = new Node(node2, 1);
//        Node node4 = new Node(node3, 0);
//        node4.print();
//        System.out.println();
//        reversed(node4).print();

//        Node node = new Node(null, 4);
//        Node node1 = new Node(node, 3);
//        Node node2 = new Node(node1, 2);
//        Node node3 = new Node(node2, 1);
//        Node node4 = new Node(node3, 0);
//        node.setNext(node4);
//        System.out.println("is circle:\t" + isCircle(node4));

        Node aNode = createNodeA();
        Node bNode = createNodeB();
        Node node = mergeNode(aNode, bNode);
        if (node != null) {
            node.print();
        }

    }

    private static Node createNode() {
        return new Node(new Node(new Node(new Node(new Node(null, 4), 3), 2), 1), 0);
    }

    private static Node createNodeA() {
        return new Node(new Node(new Node(null, 5), 3), 1);
    }

    private static Node createNodeB() {
        return new Node(new Node(new Node(new Node(new Node(null, 9), 8), 6), 4), 2);
    }

    /**
     * @return 判断是否是回文数
     */
    private boolean isPalindrome() {
        if (head == null || head.next == null) {
            return false;
        }
        Node pre = null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            // 快指针每次跳两个
            fast = fast.next.next;
            // 勇哥临时指针指向下个节点
            Node temp = slow.next;
            // 将 slow 回转
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && pre != null) {
            if (slow.value != pre.value) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    private static Node reversed(Node node) {
        if (node.next == null) {
            return node;
        }
        Node pre = null;
        while (node != null) {
            // 现将下个节点用 temp 保存下来
            Node temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    /**
     * 判断是否是循环链表
     * 快慢节点，如果两者相等必然是循环链表，时间复杂度为 O(n)
     */
    private static boolean isCircle(Node node) {
        int count = 0;
        Node slow = node;
        Node fast = node;
        while (slow != null && fast != null && fast.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("循环了 " + count + "次");
                return true;
            }
        }
        System.out.println("循环了 " + count + "次");
        return false;
    }

    private static Node mergeNode(Node aNode, Node bNode) {
        Node head = new Node(null, -1);
        Node tail = head;
        if (aNode == null) {
            head = bNode;
        }
        if (bNode == null) {
            head = aNode;
        }

        while (aNode != null && bNode != null) {
            if (aNode.value > bNode.value) {
                tail.next = bNode;
                bNode = bNode.next;
            } else {
                tail.next = aNode;
                aNode = aNode.next;
            }
            tail = tail.next;
        }
        if (aNode == null) {
            tail.next = bNode;
        }
        if (bNode == null) {
            tail.next = aNode;
        }
        if (head == null) {
            return null;
        }
        return head.next;
    }
}
