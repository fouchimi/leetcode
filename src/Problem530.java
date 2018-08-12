import java.util.ArrayList;
import java.util.List;

public class Problem530 {

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 0; i < list.size(); i++) {
            for(int j =i+1; j < list.size(); j++) {
                min = Math.min(min, Math.abs(list.get(i)-list.get(j)));
            }
        }
        return list.size() > 1 ? min : list.get(0);
    }

    private void inOrder(TreeNode x, List<Integer> list) {
        if(x == null) return;
        inOrder(x.left, list);
        list.add(x.val);
        inOrder(x.right, list);
    }

    public static void main(String[] args) {
        Problem530 problem530 = new Problem530();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(problem530.getMinimumDifference(root));
    }
}
