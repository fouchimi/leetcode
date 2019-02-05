import java.util.HashMap;
import java.util.Map;

public class Problem523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        if(k < 0) k *= -1;
        for(int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if((k > 0 && sum % k == 0) || (k == 0 && sum == 0)) count++;
            }
        }
        return count > 0;
    }

    public boolean checkSubarraySumImproved(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(k != 0) prefixSum %= k;
            Integer prev = map.get(prefixSum);
            if(prev != null) {
                if(i - prev > 1) return true;
            }
            else map.put(prefixSum, i);
        }

        return false;
    }

    public static void main(String[] args) {
        Problem523 problem523 = new Problem523();
        int[] nums = {0, 0, 0};
        int k = 0;
        System.out.println(problem523.checkSubarraySum(nums, k));
    }
}
