import java.util.*;

public class Problem368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        else if(nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            return l;
        }else {
            Arrays.sort(nums);
            List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                List<Integer> leftList = new ArrayList<>();
                leftList.add(nums[i]);
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j]%leftList.get(leftList.size()-1) == 0) leftList.add(nums[j]);
                }

                if(leftList.size() == nums.length) return leftList;
                if(left.size() < leftList.size()) left = new ArrayList<>(leftList);

            }

            for(int i = nums.length-1; i > 0; i--) {
                List<Integer> rightList = new ArrayList<>();
                rightList.add(nums[i]);
                for(int j = i-1; j >= 0; j--) {
                    if(rightList.get(0)%nums[j] == 0) rightList.add(0, nums[j]);
                }

                if(rightList.size() == nums.length) return rightList;
                if(right.size() < rightList.size()) right = new ArrayList<>(rightList);
            }

            return right.size() > left.size() ? right : left;
        }
    }

    public static void main(String[] args) {
        Problem368 problem368 = new Problem368();
        int[] nums = {1, 2, 4, 8, 16};
        System.out.println(problem368.largestDivisibleSubset(nums));
    }
}
