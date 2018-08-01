import java.util.ArrayList;
import java.util.List;

public class Problem144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalUtil(root, list);
        return list;
    }

    private void preOrderTraversalUtil(TreeNode x, List<Integer> list) {
        if(x == null) return;
        list.add(x.val);
        preOrderTraversalUtil(x.left, list);
        preOrderTraversalUtil(x.right, list);
    }

    public static void main(String[] args) {
        Problem144 problem144 = new Problem144();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = problem144.preorderTraversal(root);
        for(Integer w : list) System.out.print(w + " ");
        System.out.println();
    }
}
