
public class Problem993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        int[] ans = new int[4];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MIN_VALUE;
        ans[2] = Integer.MIN_VALUE;
        ans[3] = Integer.MIN_VALUE;
        isCousinsDepthUtil(root, x, y, Integer.MIN_VALUE, Integer.MIN_VALUE, ans, 0);
        return ans[0] == ans[1] && ans[2] != ans[3];
    }

    private TreeNode isCousinsDepthUtil(TreeNode x, int p, int q, int parentP, int parentQ, int[] ans, int depth) {
        if(x == null || ans[0] != Integer.MIN_VALUE && ans[1] != Integer.MIN_VALUE) return null;
        if(x.val == p){
            ans[0] = depth;
            ans[2] = parentP;
        }
        if(x.val == q){
            ans[1] = depth;
            ans[3] = parentQ;
        }
        x.left = isCousinsDepthUtil(x.left, p, q, x.val, x.val, ans, depth+1);
        x.right = isCousinsDepthUtil(x.right, p, q, x.val, x.val, ans, depth+1);
        return x;
    }

    public static void main(String[] args) {
        Problem993 problem993 = new Problem993();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(problem993.isCousins(root, 4, 3));

        TreeNode secondRoot = new TreeNode(1);
        secondRoot.left = new TreeNode(2);
        secondRoot.right = new TreeNode(3);
        secondRoot.left.right = new TreeNode(4);
        secondRoot.right.right = new TreeNode(5);
        System.out.println(problem993.isCousins(secondRoot, 5, 4));
    }
}


