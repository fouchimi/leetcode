import java.util.Stack;

public class Problem255 {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        Integer root = Integer.MIN_VALUE;
        stack.push(root);
        for(int i = 0; i  < preorder.length; i++) {
            if(preorder[i] < root) return false;
            while (!stack.isEmpty() && stack.peek() < preorder[i]) root = stack.pop();
            stack.push(preorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem255 problem255 = new Problem255();
        int[] arr = {5,2,6,1,3};
        System.out.println(problem255.verifyPreorder(arr));
        int[] arr1 = {5,2,1,3,6};
        System.out.println(problem255.verifyPreorder(arr1));
        int[] arr2 = {2, 3, 1};
        System.out.println(problem255.verifyPreorder(arr2));

    }
}
