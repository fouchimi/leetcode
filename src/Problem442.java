import java.util.ArrayList;
import java.util.List;

public class Problem442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0) res.add(index+1);
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem442 problem442 = new Problem442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3 , 1};
        System.out.println(problem442.findDuplicates(nums));
    }
}
