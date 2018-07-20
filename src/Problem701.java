public class Problem701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        else if(val > root.val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.right, val);
        }else if(val < root.val) {
            if(root.left == null) {
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        }else {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root.left;
            root.left = newNode;
            return root;
        }
        return root;
    }

    private void printTree(TreeNode x) {
        if(x == null) return;
        printTree(x.left);
        System.out.print(x.val + " ");
        printTree(x.right);
    }

    public static void main(String[] args) {
        Problem701 problem701 = new Problem701();
        TreeNode root  = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        problem701.printTree(problem701.insertIntoBST(root, 5));

    }
}
