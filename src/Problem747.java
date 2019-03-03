public class Problem747 {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, index = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) continue;
            else if(2 * nums[i] > max) return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        Problem747 problem747 = new Problem747();
        int[] nums = {3, 6, 1, 0};
        System.out.println(problem747.dominantIndex(nums));

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(problem747.dominantIndex(nums1));
    }
}
