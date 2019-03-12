import java.util.ArrayList;
import java.util.List;

public class Problem897 {

    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        increasingBSTUtil(root, list);
        for(int i = 1; i < list.size(); i++) {
            list.get(i).left = null;
            list.get(i-1).right = list.get(i);
        }
        return list.get(0);
    }

    private void increasingBSTUtil(TreeNode x, List<TreeNode> list) {
        if(x == null) return;
        increasingBSTUtil(x.left, list);
        list.add(x);
        increasingBSTUtil(x.right, list);
    }

    public static void main(String[] args) {
        Problem897 problem897 = new Problem897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        System.out.println(problem897.increasingBST(root));
    }
}
