public class Problem360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            nums[i] = a * nums[i] * nums[i] + b * nums[i] + c;

        int i, d;
        int p = 0, q = nums.length-1;
        if(a < 0) {
            i = p;
            d = 1;
        }else {
            i = q;
            d = -1;
        }

        while (p <= q) {
            if(nums[p] * (-d) > nums[q] * (-d)) {
                result[i] = nums[p];
                p++;
            }else {
                result[i] = nums[q];
                q--;
            }
            i += d;
        }

        for(int w : result) System.out.print(w + " ");

        return result;
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
