
public class Problem494 {

    private static int counter = 0;

    public int findTargetSumWays(int[] nums, int s) {
        counter = 0;
        dfs(0, nums, 0,  s);
        return counter;
    }

    private void dfs(int cur, int[] nums, int sum, int S) {
        if (sum == S && cur == nums.length) counter += 1;
        if (cur >= nums.length) return;
        dfs(cur + 1,nums,sum + nums[cur],S);
        dfs(cur + 1,nums,sum + nums[cur] * (-1),S);
        return;
    }

    public static void main(String[] args) {
        Problem494 problem494 = new Problem494();
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(problem494.findTargetSumWays(nums, 1));
    }
}
