import java.util.*;

public class Problem414 {

    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.size() < 3) return list.get(list.size()-1);
        return list.get(list.size()-3);
    }

    public static void main(String[] args) {
        Problem414 problem414 = new Problem414();

        int[] nums = {1,2,2,5,3,5};
        System.out.println(problem414.thirdMax(nums));
    }
}
