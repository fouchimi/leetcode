
public class Problem543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return 0;
        int[] max = new int[1];
        int left = diameterOfBinaryTreeUtil(root.left, max);
        int right = diameterOfBinaryTreeUtil(root.right, max);
        return Math.max(max[0], left + right);
    }

    private int diameterOfBinaryTreeUtil(TreeNode x, int[] max) {
        if(x == null) return 0;
        int left = 0, right = 0;
        left += diameterOfBinaryTreeUtil(x.left, max);
        right += diameterOfBinaryTreeUtil(x.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Problem543 problem543 = new Problem543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        /*root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/
        System.out.println(problem543.diameterOfBinaryTree(root));
    }

}
