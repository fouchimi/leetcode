public class Problem307 {

    static class NumArray {

        int[][] arr;
        public NumArray(int[] nums) {
            arr = new int[2][nums.length];
            for(int i = 0; i < arr[0].length; i++) {
                arr[1][i] = nums[i];
            }
        }

        public void update(int i, int val) {
            arr[1][i] = val;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for(int k = i; k <= j && j < arr[0].length; k++) {
                sum += arr[1][k];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
