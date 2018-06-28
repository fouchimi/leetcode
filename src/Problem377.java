
public class Problem377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            for (int i = 0; i < nums.length; i++) {
                if (t - nums[i] >= 0) {
                    dp[t] += dp[t - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Problem377 problem377 = new Problem377();
        int[] nums = {1, 2, 3};
        System.out.println(problem377.combinationSum4(nums, 4));
    }
}
