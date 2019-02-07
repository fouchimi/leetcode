public class Problem298 {
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        max = Math.max(max, Math.max(longestConsecutiveUtil(root) + 1, Math.max(longestConsecutive(root.left), longestConsecutive(root.right))));
        return max;
    }

    private int longestConsecutiveUtil(TreeNode x) {
        if(x == null) return 0;
        int left = 0, right = 0;
        if(x.left != null && x.left.val == x.val + 1) left += longestConsecutiveUtil(x.left) + 1;
        if(x.right != null && x.right.val == x.val + 1) right += longestConsecutiveUtil(x.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Problem298 problem298 = new Problem298();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(problem298.longestConsecutive(root));
    }
}
