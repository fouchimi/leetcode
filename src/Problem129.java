public class Problem129 {
    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        sumNumbersUtil(root, "", result);
        return result[0];
    }

    private TreeNode sumNumbersUtil(TreeNode x, String val, int[] result) {
        if(x == null) return null;
        x.left = sumNumbersUtil(x.left, val + x.val, result);
        x.right = sumNumbersUtil(x.right, val + x.val, result);
        if(x.left == null && x.right == null) result[0] = Integer.parseInt(val+x.val) + result[0];

        return x;
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode(4);
        first.left = new TreeNode(9);
        first.right = new TreeNode(0);
        first.left.left = new TreeNode(5);
        first.left.right = new TreeNode(1);
        Problem129 pb29 = new Problem129();
        System.out.println(pb29.sumNumbers(first));
    }
}
