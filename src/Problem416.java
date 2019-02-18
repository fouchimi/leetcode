
public class Problem416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum % 2 != 0) return false;
        int target = sum /2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return canPartitionUtil(nums, 0, target, memo);
    }

    private boolean canPartitionUtil(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        if (canPartitionUtil(nums, index + 1, target, memo) || canPartitionUtil(nums, index + 1, target - nums[index], memo)) {
            memo[index][target] = true;
            return true;
        }
        memo[index][target] = false;
        return false;
    }

    public static void main(String[] args) {
        Problem416 problem416 = new Problem416();
        int[] nums = {1, 5, 11, 5};
        //int[] values = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
        //System.out.println(problem416.canPartition(nums));
//        System.out.println(problem416.canPartition(new int[]{1, 2, 3, 5}));
       System.out.println(problem416.canPartition(new int[]{2, 2, 3, 5}));
        //System.out.println(problem416.canPartition(values));
    }
}
