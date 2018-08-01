public class Problem563 {

    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        int[] arr = new int[1];
        findTiltUtil(root, arr);
        return arr[0];
    }

    private void findTiltUtil(TreeNode x, int[] arr) {
        if(x == null) return;
        findTiltUtil(x.left, arr);
        findTiltUtil(x.right, arr);
        if(x.left != null && x.right != null) {
            arr[0] += Math.abs(x.left.val - x.right.val);
            x.val += x.left.val + x.right.val;
        }
        else if(x.left != null) {
            arr[0] += Math.abs(x.left.val);
            x.val += x.left.val;
        }
        else if(x.right != null) {
            arr[0] += Math.abs(x.right.val);
            x.val += x.right.val;
        }
    }

    public static void main(String[] args) {
        Problem563 problem563 = new Problem563();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(problem563.findTilt(root));
    }
}
