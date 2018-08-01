import java.util.Stack;

public class Problem496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>(), tempStack = new Stack<>();
        int nextMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums2.length; i++) stack.push(nums2[i]);

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            while (!stack.isEmpty() &&  stack.peek() != nums1[i]) {
               if(stack.peek() > nums1[i]) nextMax = stack.peek();
               tempStack.push(stack.pop());
            }

            if(nextMax > nums1[i])
                result[i] = nextMax;
            else result[i] = -1;

            while (!tempStack.isEmpty()) stack.push(tempStack.pop());
            nextMax = Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        Problem496 problem496 = new Problem496();
        int[] result = problem496.nextGreaterElement(nums1, nums2);
        for(int w : result) System.out.print(w + " ");
    }
}
