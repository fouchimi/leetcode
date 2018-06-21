import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultList = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();
        findSubsequencesUtil(nums, list, resultList,0);
        return new ArrayList<>(resultList);
    }

    private void findSubsequencesUtil(int[] nums, List<Integer> list, Set<List<Integer>> resultList, int index) {
        if(list.size() >= 2) {
            resultList.add(new ArrayList<>(list));
        }
        for(int i = index; i < nums.length; i++) {
            if(list.isEmpty() || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                findSubsequencesUtil(nums, list, resultList,  i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        Problem491 problem491 = new Problem491();
        System.out.println(problem491.findSubsequences(nums));
    }
}
