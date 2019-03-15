public class Problem643 {

    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;
        for(int i = 0; i + k <= nums.length; i++) {
            double sum = 0.0d;
            for(int j = i; j < i+k; j++) sum += nums[j];
            maxAverage = Math.max(maxAverage, sum / k);
        }
        return maxAverage;
    }

    public double findMaxAverateImproved(int[] nums, int k) {
        double sum = 0.0d, maxAverage = -Double.MAX_VALUE;
        for(int i = 0; i < k; i++) sum += nums[i];
        for(int p = 0, q = k; q <= nums.length; p++, q++){
            maxAverage = Math.max(maxAverage, sum / k);
            if(q == nums.length) break;
            sum -= nums[p];
            sum += nums[q];
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        Problem643 problem643 = new Problem643();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(problem643.findMaxAverage(nums, 4));
        int[] nums1 = {-1};
        System.out.println(problem643.findMaxAverage(nums1, 1));

        int[] nums2 = {1,12,-5,-6,50,3};
        System.out.println(problem643.findMaxAverateImproved(nums2, 4));
        System.out.println(problem643.findMaxAverateImproved(nums1, 1));
    }
}
