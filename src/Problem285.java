import java.util.ArrayList;
import java.util.List;

public class Problem285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        inorderSuccessorUtil(root, list);
        int i = 0;
        for(; i < list.size(); i++) {
            if(list.get(i) == p) break;
        }
        if(i == list.size() - 1) return null;
        return list.get(i+1);
    }

    private void inorderSuccessorUtil(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inorderSuccessorUtil(root.left, list);
        list.add(root);
        inorderSuccessorUtil(root.right, list);
    }
}
