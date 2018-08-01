
public class Problem152 {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int leftProd = Integer.MIN_VALUE, rightProd = Integer.MIN_VALUE;
        int left = 1, right = 1, leftCount = 0, rightCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                left *= nums[i];
                if(left > 0) {
                    leftProd = Math.max(leftProd, left);
                }else {
                    leftProd = Math.max(leftProd, nums[i]);
                }
            }else {
                left = 1;
                leftCount++;
            }
        }

        if(leftCount > 0) leftProd = Math.max(leftProd, 0);

        for(int j = nums.length -1; j >= 0; j--) {
            if(nums[j] != 0) {
                right *= nums[j];
                if(right > 0) {
                    rightProd = Math.max(rightProd, right);
                }else {
                    rightProd = Math.max(rightProd, nums[j]);
                }
            }else {
                right = 1;
                rightCount++;
            }
        }

        if(rightCount > 0) rightProd = Math.max(rightProd, 0);

        return Math.max(leftProd, rightProd);
    }

    public static void main(String[] args) {
        Problem152 problem152 = new Problem152();
        int[] nums = {-2,-3, -6};
        System.out.println(problem152.maxProduct(nums));
    }

}
