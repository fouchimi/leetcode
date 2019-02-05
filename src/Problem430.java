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
    }

    public Node flatten(Node head) {
        if(head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node current = head, newHead = current;
        while(current.next != null) {
            if(current.child != null) {
                stack.push(current.next);
                current.next = current.child;
                current = current.child;
            }else current = current.next;
        }

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            while (current.next != null) current = current.next;
        }
        return newHead;
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

        Node firstList = new Node(1, null, null, null);
        firstList.next = new Node(2, null, null, null);
        firstList.next.next = new Node(3, null, null, null);
        firstList.next.next.next = new Node(4, null, null, null);
        firstList.next.next.next.next = new Node(5, null, null, null);
        firstList.next.next.next.next.next = new Node(6, null, null, null);
        firstList.next.next.child = new Node(7, null, null, null);
        firstList.next.next.child.next = new Node(8, null, null, null);
        firstList.next.next.child.next.next = new Node(9, null, null, null);
        firstList.next.next.child.next.next.next = new Node(10, null, null, null);
        firstList.next.next.child.next.child = new Node(11, null, null, null);
        firstList.next.next.child.next.child.next = new Node(12, null, null, null);

        Node result = problem430.flatten(firstList);
        problem430.printList(result);

    }
}
