import java.util.*;

public class Problem508 {

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        findFrequentTreeSumUtil(root);
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    private int findFrequentTreeSumUtil(TreeNode x) {
        if(x == null) return 0;
        int left = findFrequentTreeSumUtil(x.left);
        int right = findFrequentTreeSumUtil(x.right);
        int sum = x.val + left + right;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        maxCount = Math.max(maxCount, count);
        return sum;

    }

    public static void main(String[] args) {
        Problem508 problem508 = new Problem508();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        int[] result = problem508.findFrequentTreeSum(root);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}
