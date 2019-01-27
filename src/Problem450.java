
public class Problem450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode x) {
        if(x.left == null) return x;
        x = findMin(x.left);
        return x;
    }

    public void print(TreeNode x) {
        if(x == null) return;
        print(x.left);
        System.out.print(x.val + " ");
        print(x.right);
    }

    public static void main(String[] args) {
        Problem450 problem450 = new Problem450();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        problem450.print(root);
        TreeNode newRoot = problem450.deleteNode(root, 2);
        System.out.println();
        problem450.print(newRoot);
    }
}
