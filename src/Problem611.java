import java.util.Arrays;

public class Problem611 {

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                   if(nums[i] + nums[j] > nums[k]) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem611 problem611 = new Problem611();
        int[] nums = {2,2,3,4};
        System.out.println(problem611.triangleNumber(nums));
    }
}
