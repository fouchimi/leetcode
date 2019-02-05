import java.util.*;

public class Problem250 {

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if(dfs(x, new HashSet<>()) == 1) count++;
            if(x.left != null) queue.add(x.left);
            if(x.right != null) queue.add(x.right);

        }
        return count;
    }

    private int dfs(TreeNode x, Set<Integer> set) {
        if(x == null) return 0;
        dfs(x.left, set);
        set.add(x.val);
        dfs(x.right, set);
        return set.size();
    }

    public static void main(String[] args) {
        Problem250 problem250 = new Problem250();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(problem250.countUnivalSubtrees(root));
    }
}
