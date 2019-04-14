import java.util.*;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        queue.add(root);
        list.add(root);
        while(!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if(x.left != null) {
                queue.add(x.left);
                list.add(x.left);
            }
            if(x.right != null) {
                queue.add(x.right);
                list.add(x.right);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            int sum = 0;
            for(int j = 0; j < list.size(); j++) {
                if(i != j && list.get(j).val > list.get(i).val) sum += list.get(j).val;
            }
            map.put(i, sum);
        }

        for(int i = 0; i < list.size(); i++) list.get(i).val += map.get(i);
        return root;
    }

    private void printTree(TreeNode x) {
        if(x == null) return;
        printTree(x.left);
        System.out.print(x.val + " ");
        printTree(x.right);
    }

    public static void main(String[] args) {
        Problem538 problem538 = new Problem538();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        problem538.printTree(root);
        problem538.convertBST(root);
        System.out.println();
        problem538.printTree(root);
    }
}
