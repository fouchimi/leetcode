public class Problem360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int prod = a * nums[i] * nums[i] + b * nums[i] + c;
            result[i] = prod;
            swim(result, i);
        }

        for(int w : result) System.out.print(w + " ");
        return result;
    }

    private void swim(int[] nums, int k){
        while (k > 0 && less(nums, k, k/2)){
            exch(nums, k, k/2);
            k = k/2;
        }
    }

    private boolean less(int[] nums, int p, int q) {
        return nums[p] < nums[q];
    }

    public void exch(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] args) {
        Problem360 problem360 = new Problem360();
        int[] nums = {-4, -2, 2, 4};
        problem360.sortTransformedArray(nums, 1, 3, 5);
    }
}
