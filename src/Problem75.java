import java.util.Map;
import java.util.TreeMap;

public class Problem75 {

    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        int k = 0;
        for(Integer key : map.keySet()) {
            for(int j = 0; j < map.get(key); j++) nums[k++] = key;
        }
        for(int w : nums) System.out.print(w + " ");
    }

    public static void main(String[] args) {
        Problem75 problem75 = new Problem75();
        int[] nums = {2,0,2,1,1,0};
        problem75.sortColors(nums);
    }
}
