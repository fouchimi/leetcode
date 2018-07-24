import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(!map.containsKey(i)) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Problem448 problem448 = new Problem448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3 , 1};
        System.out.println(problem448.findDisappearedNumbers(nums));

    }
}
