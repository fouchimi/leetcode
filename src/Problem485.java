public class Problem485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)count++;
            else if(nums[i] != 1) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return Math.max(count, maxCount);
    }

    public static void main(String[] args) {
        Problem485 problem485 = new Problem485();
        int[] nums = {1};
        System.out.println(problem485.findMaxConsecutiveOnes(nums));
    }
}
