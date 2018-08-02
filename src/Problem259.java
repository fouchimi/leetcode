import java.util.Arrays;

public class Problem259 {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] < target) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Problem259 problem259 = new Problem259();
        int[] nums = {1,-1,2,0,3,-2};
        System.out.println(problem259.threeSumSmaller(nums, 2));
    }
}
