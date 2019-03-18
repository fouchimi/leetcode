import java.util.HashSet;
import java.util.Set;

public class Problem965 {

    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        return set.size() == 1;
    }

    private void dfs(TreeNode x, Set<Integer> set) {
        if(x == null) return;
        set.add(x.val);
        dfs(x.left, set);
        dfs(x.right, set);
    }

    public static void main(String[] args) {
        Problem965 problem965 = new Problem965();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(problem965.isUnivalTree(root));

        TreeNode secondRoot = new TreeNode(2);
        secondRoot.left = new TreeNode(2);
        secondRoot.right = new TreeNode(2);
        secondRoot.left.left = new TreeNode(5);
        secondRoot.left.right = new TreeNode(2);
        System.out.println(problem965.isUnivalTree(secondRoot));
    }
}
