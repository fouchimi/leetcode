import java.util.Arrays;

public class Problem561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) maxSum += nums[i];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Problem561 problem561 = new Problem561();
        System.out.println(problem561.arrayPairSum(new int[] {1, 4, 3, 2}));
    }
}
