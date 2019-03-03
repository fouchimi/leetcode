import java.util.HashMap;
import java.util.Map;

public class Problem137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

        for(Integer key : map.keySet()) {
            if(map.get(key) == 1) return key;
        }
        return -1;
    }

    public int singleNumberImproved(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }

                if(sum == 1) {
                    ans |= sum << i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem137 problem137 = new Problem137();
        int[] nums = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,
                -2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(problem137.singleNumber(nums));
        System.out.println(problem137.singleNumberImproved(nums));
    }
}
