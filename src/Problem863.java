import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        else if(K == 0) {
            list.add(target.val);
            return list;
        }else {
            if(root == target) getNodesUtil(root, K, list);
            else {
                Stack<TreeNode> stack = new Stack<>();
                findParentsNode(root, target, stack);
                int N = stack.size()-1;
                while (!stack.isEmpty()) {
                    TreeNode parentNode = stack.get(0);
                    if(parentNode != target) {
                        if(K == N) list.add(parentNode.val);
                        else if(K > N){
                            if(stack.contains(parentNode.left)) getNodesUtil(parentNode.right, K-N-1, list);
                            else if(stack.contains(parentNode.right)) getNodesUtil(parentNode.left, K-N-1, list);
                        }

                    }else getNodesUtil(parentNode, K, list);
                    stack.remove(0);
                    N--;
                }
            }
        }
        return list;
    }

    public TreeNode findParentsNode(TreeNode x, TreeNode target, Stack<TreeNode> stack) {
        if(x == null) return null;
        stack.push(x);
        if(stack.peek() == target) return x;
        x.left = findParentsNode(x.left, target, stack);
        x.right = findParentsNode(x.right, target, stack);
        if(stack.peek() != target) stack.pop();
        return x;
    }

    public void getNodesUtil(TreeNode x, int K, List<Integer> list) {
        if( K < 0 || x == null) return;
        else if(K == 0) {
            list.add(x.val);
            return;
        }
        getNodesUtil(x.left, K-1, list);
        getNodesUtil(x.right, K-1, list);
    }

    public static void main(String[] args) {
        Problem863 problem863 = new Problem863();
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.left.right = new TreeNode(3);
        root.right.left.right.left = new TreeNode(4);
        System.out.println(problem863.distanceK(root, root.right.left, 2));
    }

}