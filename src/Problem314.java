import java.util.*;

public class Problem314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0, max = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if(!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(node.val);

            if(node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if(node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }

        }

        for(int i = min; i <= max; i++) result.add(map.get(i));
        return result;
    }

    private void print(List<List<Integer>> resultList) {
        for(List<Integer> list : resultList) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Problem314 problem314 = new Problem314();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = problem314.verticalOrder(root);
        problem314.print(result);
    }
}
