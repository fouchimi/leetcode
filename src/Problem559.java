import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem559 {

    static class Node {
        int val;
        List<Node> children;

        Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        List<Node> children = new ArrayList<>();
        while (!queue.isEmpty()) {
            level++;
            while (!queue.isEmpty()) children.add(queue.poll());
            for(Node node : children) {
                if(node.children != null && !node.children.isEmpty()) {
                    for(Node childNode : node.children) queue.offer(childNode);
                }
            }
            while (!children.isEmpty()) children.remove(0);
        }
        return level;
    }

    public static void main(String[] args) {
        Problem559 problem559 = new Problem559();
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
        System.out.println(problem559.maxDepth(firstNode));


    }
}
