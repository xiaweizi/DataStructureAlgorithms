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

        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(2);
        linkedList.insertLast(1);
        System.out.println("是否为回文函数:\t" + linkedList.isPalindrome());
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
        while (slow != null &&  pre != null) {
            if (slow.value != pre.value) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
