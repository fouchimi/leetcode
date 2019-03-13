import java.util.*;

public class Problem133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Deque<Node> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(node);
        while (!nodeDeque.isEmpty()) {
            Node currentNode = nodeDeque.poll();
            for(Node neighbor : currentNode.neighbors) {
                if(nodeMap.putIfAbsent(neighbor, new Node(neighbor.val, new ArrayList<>())) == null) {
                    nodeDeque.add(neighbor);
                }
                nodeMap.get(currentNode).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return nodeMap.get(node);
    }
}
