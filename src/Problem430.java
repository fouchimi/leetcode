import java.util.Stack;

public class Problem430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

        public Node(int _val) {
            val = _val;
        }
    }

    private Node prev;
    public Node flatten(Node head) {
        if(head == null) return null;
        Node current = head;
        prev = head;
        while (current != null) {
            if(current.child != null) {
                Node temp = current.next;
                current.next = flatten(current.child);
                current.child = null;
                current.next.prev = current;
                prev.next = temp;
                if(temp != null) temp.prev = prev;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    private void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Problem430 problem430 = new Problem430();

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        Node ninth = new Node(9);
        Node tenth = new Node(10);
        Node eleventh = new Node(11);
        Node twelfth = new Node(12);
        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        third.child = seventh;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        fifth.next = sixth;
        sixth.prev = fifth;
        seventh.next = eighth;
        eighth.prev = seventh;
        eighth.next = ninth;
        eighth.child = eleventh;
        ninth.prev = eighth;
        ninth.next = tenth;
        tenth.prev = ninth;
        eleventh.next = twelfth;
        twelfth.prev = eleventh;

        Node result = problem430.flatten(first);
        problem430.printList(result);

    }
}
