public class Problem337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    public int[] helper(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] res = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args){
        Problem337 problem337 = new Problem337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(problem337.rob(root));

    }

}
