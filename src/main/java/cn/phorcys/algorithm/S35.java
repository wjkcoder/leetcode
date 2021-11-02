package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/28 下午12:18
 */
public class S35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int[] arr) {
            Node head = new Node(-1);
            for (int i = arr.length - 1; i >= 0; i--) {
                Node node = new Node(arr[i]);
                if (head.next != null) {
                    node.next = head.next;
                    head.next = node;
                } else {
                    head.next = node;
                }
            }
            Node cur = head.next;
            val = cur.val;
            next = cur.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        for (Node cur = head; cur != null; cur = cur.next.next) {
            /*赋值每一个node放在原节点之后*/
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
        }
        /*赋值random*/
        for (Node cur = head; cur != null; cur = cur.next.next) {
            /*赋值每一个node放在原节点之后*/
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        /*已存在一个 A A1 B B1的链表需要重新组合节点*/
        Node newHead = head.next;
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            Node copy1 = cur.next;
            Node node2 = copy1.next;
            if (node2 != null) {
                copy1.next = node2.next;
                cur.next = node2;
            } else {
                cur.next = null;
                copy1.next = null;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node = new Node(new int[]{7, 13, 11, 10, 1});
        new S35().copyRandomList(node);

    }

    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 0) return true;
        Integer last = null;
        for (String item : arr) {
            try {
                int value = Integer.parseInt(item);
                if (last == null) {
                    last = value;
                } else {
                    if (value <= last) return false;
                    else last = value;
                }
            } catch (Exception ignored) {
            }
        }
        return true;
    }
}
