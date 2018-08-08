import java.util.ArrayList;
import java.util.List;

public class Problem783 {

    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        minDiffInBSTUtil(root, list);
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                int currentMinDiff = Math.abs(list.get(j)-list.get(i));
                if(currentMinDiff < minDiff) minDiff = currentMinDiff;
            }
        }
        return minDiff;
    }

    private void minDiffInBSTUtil(TreeNode x, List<Integer> list) {
        if(x == null) return;
        list.add(x.val);
        minDiffInBSTUtil(x.left, list);
        minDiffInBSTUtil(x.right, list);
    }

    public static void main(String[] args){
        Problem783 problem783 = new Problem783();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(problem783.minDiffInBST(root));
    }
}
