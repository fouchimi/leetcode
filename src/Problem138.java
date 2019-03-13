import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Problem138 {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();

        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val, null, null));
            current = current.next;
        }

        current = head;
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }

        return nodeMap.get(head);
    }

    public static void main(String[] args) {
        Problem138 problem138 = new Problem138();
        Node second = new Node(2, null, null);
        second.random = second;
        Node first = new Node(1, second, second);
        Node head = problem138.copyRandomList(first);
        while (head != null) {
            System.out.print("value: " + head.val);
            if(head.next != null) {
                System.out.print(" Next: " + head.next.val);
            }
            System.out.print(" Random: " + head.random.val);
            System.out.println();
            head = head.next;
        }
    }

}
