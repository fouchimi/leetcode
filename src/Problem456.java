public class Problem456 {

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int[] minLeft = new int[nums.length];
        int leftMin = Integer.MAX_VALUE;
        minLeft[0] = leftMin;
        for(int i = 1; i < nums.length; i++) {
            leftMin = Math.min(leftMin, nums[i-1]);
            minLeft[i] = leftMin;
        }
        for(int i = 1; i < nums.length; i++) {
            int j = i+1;
            while (j < nums.length) {
                if(minLeft[i] < nums[j] && nums[j] < nums[i]) return true;
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem456 problem456 = new Problem456();
        int[] nums = {3,5,0,3,4};
        System.out.println(problem456.find132pattern(nums));
    }
}
