import java.util.*;

public class Problem334 {

    public boolean increasingTriplet(int[] nums) {

        Stack<Integer> stack = new Stack<>(), secondStack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty() || (nums[i] > stack.peek() && stack.size() < 3)) {
                stack.push(nums[i]);
            }
            else if(stack.peek() > nums[i]) {
                while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                    if(secondStack.isEmpty() && stack.size() == 2) {
                        while(!stack.isEmpty()) {
                            secondStack.add(0, stack.peek());
                            stack.pop();
                        }
                    }
                    else if(secondStack.isEmpty() || (secondStack.size() < 3) && secondStack.peek() < stack.peek()) secondStack.push(stack.peek());
                    if(!stack.isEmpty()) stack.pop();
                }
                stack.push(nums[i]);
            }
            if(stack.size() == 3 || secondStack.size() == 3) return true;
        }

        return secondStack.size() == 2 && stack.peek() > secondStack.peek();
    }

    public static void main(String[] args) {
        Problem334 problem334 = new Problem334();
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,3};
        System.out.println(problem334.increasingTriplet(nums));
    }
}
