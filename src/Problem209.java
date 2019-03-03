public class Problem209 {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while(end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            while (start < end && sum >= s) {
                min = Math.min(min, end-start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Problem209 problem209 = new Problem209();
        System.out.println(problem209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
