import java.util.ArrayList;
import java.util.List;

public class Problem590 {

    static class Node {
        int val;
        List<Node> children;

        Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrderUtil(root, list);
        return list;
    }

    private void preOrderUtil(Node x, List<Integer> list) {
        if(x == null) return;
        list.add(x.val);
        if(x.children != null && !x.children.isEmpty()) {
            for(Node currentNode : x.children) {
                preOrderUtil(currentNode, list);
            }
        }
    }

    public static void main(String[] args){
         Problem590 problem590 = new Problem590();
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
         List<Integer> l = problem590.preorder(firstNode);
         for(Integer val : l) System.out.print(val + " ");
    }
}
