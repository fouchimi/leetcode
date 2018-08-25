
import java.util.*;

public class Problem429 {

    static class Node {
        int val;
        List<Node> children;

        Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Node> children = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                tempList.add(currentNode.val);
                children.add(currentNode);
            }
            res.add(tempList);
            for(Node node : children) {
                if(node.children != null && !node.children.isEmpty()) {
                    for(Node childNode : node.children) queue.offer(childNode);
                }
            }
            while (!children.isEmpty()) children.remove(0);
        }
        return res;
    }

    public static void main(String[] args){
        Problem429 problem429 = new Problem429();
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
        List<List<Integer>> resultList = problem429.levelOrder(firstNode);
        for(List<Integer> list : resultList) System.out.println(list);
    }
}
