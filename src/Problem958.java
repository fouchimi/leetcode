import java.util.LinkedList;
import java.util.Queue;

public class Problem958 {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if(top == null) break;
            if(top.left == null && top.right != null) return false;
            queue.add(top.left);
            queue.add(top.right);
        }

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if(top != null) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Problem958 problem958 = new Problem958();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(problem958.isCompleteTree(root));
    }
}
