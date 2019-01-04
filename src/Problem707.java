public class Problem707 {

    class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head = null, tail = null;
    int N;

    public Problem707() {
        N = 0;
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    private boolean isEmpty() {
        return head.next == tail && tail.prev == head;
    }

    public int get(int index) {
        if(index >= N || isEmpty()) return -1;
        else {
            Node current = head.next;
            while (index > 0) {
                current = current.next;
                index--;
            }
            return current.val;
        }
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node prevHead = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next = prevHead;
        prevHead.prev = newNode;
        N++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node prevTail = tail.prev;
        newNode.prev = prevTail;
        newNode.next = tail;
        prevTail.next = newNode;
        tail.prev = newNode;
        N++;
    }

    public void addAtIndex(int index, int val) {
        if(index > N) return;
        Node current = head.next;
        while (index > 0) {
            current = current.next;
            index--;
        }
        Node newNode = new Node(val);
        Node tempPrev = current.prev;
        newNode.prev = tempPrev;
        newNode.next = current;
        current.prev = newNode;
        tempPrev.next = newNode;
        N++;
    }

    public void deleteAtIndex(int index) {
        if(index >= N || isEmpty()) return;
        Node current = head.next;
        while (index > 0) {
            current = current.next;
            index--;
        }
        Node prev = current.prev;
        Node next = current.next;
        prev.next = next;
        next.prev = prev;
        N--;
    }

    private void print() {
        if(isEmpty()) return;
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem707 linkedList = new Problem707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.print();
        linkedList.addAtIndex(1, 2);
        linkedList.print();
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(2);
        linkedList.print();
        linkedList.deleteAtIndex(2);
        System.out.println(linkedList.get(1));
    }

}
