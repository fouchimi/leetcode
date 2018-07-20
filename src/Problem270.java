import java.util.ArrayList;
import java.util.List;

public class Problem270 {

    private static int min = 0;
    public int closestValue(TreeNode root, double target){
        List<Double> minList = new ArrayList<>();
        closestValueUtil(root, target, minList);
        return min;
    }

    private void closestValueUtil(TreeNode x, double target, List<Double> list) {
        if(x == null) return;
        if(list.isEmpty()) {
            list.add(Math.abs(x.val-target));
            min = x.val;
        }else if(Math.abs(x.val-target) < list.get(list.size()-1)) {
            list.remove(0);
            list.add(Math.abs(x.val-target));
            min = x.val;
        }
        closestValueUtil(x.left, target, list);
        closestValueUtil(x.right, target, list);
    }


    public static void main(String[] args) {
        Problem270 problem270 = new Problem270();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(problem270.closestValue(root, 3.714286));
    }

}
