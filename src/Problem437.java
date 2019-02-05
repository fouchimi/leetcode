public class Problem437 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumUtil(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumUtil(TreeNode x, int sum) {
        if(x == null) return 0;
        return (sum == x.val ? 1 : 0) + pathSumUtil(x.left, sum - x.val) + pathSumUtil(x.right, sum - x.val);
    }

    public static void main(String[] args) {
        Problem437 problem437 = new Problem437();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        root.left.right.right = new TreeNode(1);

        System.out.println(problem437.pathSum(root, 8));

    }
}
