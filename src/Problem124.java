public class Problem124 {
    public int maxPathSum(TreeNode root) {
        int[] maxArr = new int[1];
        maxArr[0] = Integer.MIN_VALUE;
        maxPathSumUtil(root, maxArr);
        return maxArr[0];
    }

    private TreeNode maxPathSumUtil(TreeNode x, int[] maxArr) {
        if(x == null) return null;
        x.left = maxPathSumUtil(x.left, maxArr);
        x.right = maxPathSumUtil(x.right, maxArr);
        if(x.left == null && x.right == null) maxArr[0] = Math.max(maxArr[0], x.val);
        else if(x.left != null && x.right == null) {
            maxArr[0] = Math.max(maxArr[0], Math.max(x.val, x.val + x.left.val));
            if(x.val + x.left.val > x.val) x.val += x.left.val;

        }
        else if(x.left == null && x.right != null) {
            maxArr[0] = Math.max(maxArr[0], Math.max(x.val, x.val + x.right.val));
            if(x.val + x.right.val > x.val) x.val += x.right.val;
        }
        else {
            int maxChild = Math.max(x.val + x.left.val, x.val + x.right.val);
            maxArr[0] = Math.max(maxArr[0], Math.max(maxChild, Math.max(x.val, x.val+x.left.val+x.right.val)));
            if(maxChild > x.val) x.val = maxChild;
        }
        return x;
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode(-10);
        first.left = new TreeNode(9);
        first.right = new TreeNode(20);
        first.right.left = new TreeNode(15);
        first.right.right = new TreeNode(7);
        Problem124 pb24 = new Problem124();
        System.out.println(pb24.maxPathSum(first));
    }
}
