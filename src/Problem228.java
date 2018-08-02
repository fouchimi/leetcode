import java.util.ArrayList;
import java.util.List;

public class Problem228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null && nums.length == 0) return list;
        else if(nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }else {
            int i = 0;
            while (i < nums.length) {
                int start = nums[i];
                while (i+1 < nums.length && nums[i+1] == nums[i]+1) i++;
                if(nums[i] > start) list.add(start + "->" + nums[i]);
                else list.add(String.valueOf(nums[i]));
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Problem228 problem228 = new Problem228();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(problem228.summaryRanges(nums));
    }
}
