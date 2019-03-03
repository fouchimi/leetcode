import java.util.ArrayList;
import java.util.List;

public class Problem366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return res;
        else {
            while (root != null && (root.left != null || root.right != null)) {
                List<TreeNode> tempList = new ArrayList<>();
                dfs(root, tempList);
                for(TreeNode node : tempList) list.add(node.val);
                root = deleteLeaves(root);
                res.add(list);
                list = new ArrayList<>();
            }
            list.add(root.val);
            res.add(list);
        }
        return res;
    }

    private TreeNode dfs(TreeNode x, List<TreeNode> tempList) {
        if(x == null) return null;
        x.left = dfs(x.left, tempList);
        x.right = dfs(x.right, tempList);
        if(x.left == null && x.right == null) tempList.add(x);
        return x;
    }

    private TreeNode deleteLeaves(TreeNode x) {
        if(x.left == null && x.right == null) return null;
        if(x.left != null) x.left = deleteLeaves(x.left);
        if(x.right != null) x.right = deleteLeaves(x.right);
        return x;
    }

    public static void main(String[] args) {
        Problem366 problem366 = new Problem366();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> ans = problem366.findLeaves(root);
        for(List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
