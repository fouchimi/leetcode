public class Problem376 {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        for(int i = 0; i < nums.length; i++) {
            int prev = nums[i], count = 0;
            int sign = i+1 < nums.length && nums[i+1] > nums[i] ? 1 : -1;
            for(int j = i+1; j < nums.length; j++) {
                if(sign > 0) {

                } else {

                }
            }
        }
        return 0;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for(int i = nums.length-1, tmp = 1; i >= 0; i--){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem376 problem376 = new Problem376();
        int[] values = {1, 2, 3, 4};
        int[] result = problem376.productExceptSelf(values);
        for(int value : result) System.out.print(value + " ");
    }
}
