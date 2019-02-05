import java.util.ArrayList;
import java.util.List;

public class Problem872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstList = new ArrayList<>(), secondList = new ArrayList<>();
        dfs(root1, firstList);
        dfs(root2, secondList);
        if(firstList.size() != secondList.size()) return false;
        for(int i = 0; i < firstList.size(); i++) {
            if(firstList.get(i) != secondList.get(i)) return false;
        }
        return true;
    }

    private TreeNode dfs(TreeNode root, List<Integer> list) {
        if(root == null) return null;
        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        if(root.left == null && root.right == null) list.add(root.val);
        return root;
    }
}
