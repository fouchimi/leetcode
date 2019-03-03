import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem449 {

    private static final String SEP = ",";
    private static final String NULL = "null";

    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val).append(SEP);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for(String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }

    private TreeNode getNode(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQueue = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < root.val) smallerQueue.offer(queue.poll());
        root.left = getNode(smallerQueue);
        root.right = getNode(queue);
        return root;
    }

    private void preOrder(TreeNode root) {
        if(root == null) return;
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Problem449 problem449 = new Problem449();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        String serialized = problem449.serialize(root);
        System.out.println("SERIALIZED: " + serialized);
        problem449.preOrder(root);
        TreeNode newRoot = problem449.deserialize(serialized);
        System.out.print("\nDESERIALIZED: ");
        problem449.preOrder(newRoot);
    }
}
