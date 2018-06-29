import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int max = 1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if(index + 1 < nums.length && nums[index+1] > nums[index] && (nums.length - index > max)) {
                queue.add(index+1);
                int i = index+1, count = 1;
                int last = nums[index];
                Stack<Integer> stack = new Stack<>();
                stack.push(nums[index]);
                while (i < nums.length) {
                    if(nums[i] > last) {
                        last = nums[i];
                        count++;
                    }
                    if(nums[i] > nums[index]) {
                        int size = stack.size();
                        while (!stack.isEmpty() && stack.peek() >= nums[i] && nums.length - i >= size) stack.pop();
                        if(nums[i] > stack.peek()) stack.push(nums[i]);
                    }
                    i++;
                }

                max = Math.max(max, Math.max(stack.size(), count));

            }else if(index + 1 < nums.length) queue.add(index+1);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem300 problem300 = new Problem300();
        int[] nums = {10,9,2,5,3,4};
        System.out.println(problem300.lengthOfLIS(nums));
    }
}
