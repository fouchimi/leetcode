public class Problem156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        TreeNode prev = null, temp = null, next, curr = root;

        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void print(TreeNode x) {
        if(x == null) return;
        print(x.left);
        System.out.print(x.val + " ");
        print(x.right);
    }

    public static void main(String[] args) {
        Problem156 problem156 = new Problem156();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        problem156.print(root);
        System.out.println();
        problem156.print(problem156.upsideDownBinaryTree(root));
    }

}
