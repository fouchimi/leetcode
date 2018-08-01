import java.util.ArrayList;
import java.util.List;

public class Problem163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {// check empty list
            findUtil(ans, lower - 1, upper + 1);
            return ans;
        }

        if (nums[0] > lower) {//check left most value
            findUtil(ans, lower - 1, nums[0]);
        }

        for (int i = 1; i < n; i++) {//check mid values
            if (nums[i - 1] != Integer.MAX_VALUE && nums[i - 1] + 1 < nums[i]) {
                findUtil(ans, nums[i - 1], nums[i]);
            }
        }

        if (nums[n - 1] < upper) {//check right most value
            findUtil(ans, nums[n - 1], upper + 1);
        }

        return ans;
    }

    private void findUtil(List<String> ans, int lower, int upper) {
        int dif = upper - lower;
        if (dif == 2) {
            ans.add(String.valueOf(lower + 1));
        } else {
            ans.add((lower + 1) + "->" + (upper - 1));
        }
    }
}
