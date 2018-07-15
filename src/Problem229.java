import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem229 {

    public List<Integer> majorityElement(int[] nums) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Integer w : map.keySet()) {
            if(map.get(w) > nums.length/3) list.add(w);
        }
        return list;
    }

    public static  void main(String[] args) {
        Problem229 problem229 = new Problem229();
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(problem229.majorityElement(nums));
    }
}
