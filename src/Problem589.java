import java.util.ArrayList;
import java.util.List;

public class Problem589 {

    static class Node {
        int val;
        List<Node> children;

        Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrderUtil(root, list);
        return list;
    }

    private void postOrderUtil(Node x, List<Integer> list) {
        if(x == null) return;
        if(x.children != null && !x.children.isEmpty()){
            for(Node currentNode : x.children)
                postOrderUtil(currentNode, list);
        }
        list.add(x.val);
    }

    public static void main(String[] args) {
        Problem589 problem589 = new Problem589();
        List<Node> chilrendOfThird = new ArrayList();
        Node fifthNode = new Node(5, new ArrayList<>());
        Node sixthNode = new Node(6, new ArrayList<>());
        chilrendOfThird.add(fifthNode);
        chilrendOfThird.add(sixthNode);
        Node thirdNode = new Node(3, chilrendOfThird);
        Node secondNode = new Node(2, new ArrayList<>());
        Node fourthNode = new Node(4, new ArrayList<>());
        List<Node> childrenOfFirst = new ArrayList<>();
        childrenOfFirst.add(thirdNode);
        childrenOfFirst.add(secondNode);
        childrenOfFirst.add(fourthNode);
        Node firstNode = new Node(1, childrenOfFirst);
        List<Integer> l = problem589.postorder(firstNode);
        for(Integer val : l) System.out.print(val + " ");
    }
}
