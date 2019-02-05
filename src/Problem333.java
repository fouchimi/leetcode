import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem333 {

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        queue.add(root);
        list.add(root);
        while (!queue.isEmpty()) {
            TreeNode x = queue.pop();
            if(x.left != null) {
                queue.add(x.left);
                list.add(x.left);
            }
            if(x.right != null) {
                queue.add(x.right);
                list.add(x.right);
            }
        }

        int maxSize = 0;
        for(TreeNode node : list) {
            if(isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                maxSize = Math.max(maxSize, size(node));
            }
        }
        return maxSize;
    }

    private boolean isBST(TreeNode x, int min, int max) {
        if(x == null) return true;
        if(x.val > min && x.val < max
                && isBST(x.left, min, x.val)
                && isBST(x.right, x.val, max)) {
            return true;
        }
        else return false;
    }

    private int size(TreeNode x) {
        if(x == null) return 0;
        int count = 0;
        count += size(x.left) + size(x.right) + 1;
        return count;
    }

    public static void main(String[] args) {
        Problem333 problem333 = new Problem333();
        TreeNode root = new TreeNode(10);
        //root.right = new TreeNode(2);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        System.out.println(problem333.largestBSTSubtree(root));
    }
}
