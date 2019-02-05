import java.util.ArrayList;
import java.util.List;

public class Problem426 {

    public Node treeToDoublyList(Node root) {
        List<Node>  list = new ArrayList<>();
        treeToDoublyListUtil(root, list);
        Node current = null, head = null, tail = null;
        for(Node currentNode : list) {
            if(head == null) {
                head = currentNode;
                current = head;
            }else {
                current.right = currentNode;
                current = current.right;
            }
        }

        for(int i = list.size()-1; i >= 0; i--) {
            if(tail == null) {
                tail = list.get(i);
                current = tail;
            }else {
                current.left = list.get(i);
                current = current.left;
            }
        }

        if(head != null) head.left = tail;
        if(tail != null) tail.right = head;
        return head;
    }

    private void treeToDoublyListUtil(Node x, List<Node> list) {
        if(x == null) return;
        treeToDoublyListUtil(x.left, list);
        list.add(x);
        treeToDoublyListUtil(x.right, list);
    }

    public static void main(String[] args) {
        Problem426 problem426 = new Problem426();
        Node root = new Node(4, null, null);
        root.left = new Node(2, null, null);
        root.right = new Node(5, null, null);
        root.left.left = new Node(1, null, null);
        root.left.right = new Node(3, null, null);
        problem426.treeToDoublyList(root);
    }

}
