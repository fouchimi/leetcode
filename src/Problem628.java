import java.util.Arrays;

public class Problem628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[0] * nums[1] * nums[N-1], nums[N-1] * nums[N-2] * nums[N-3]);
    }

    public static void main(String[] args) {
        Problem628 problem628 = new Problem628();

        System.out.println(problem628.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(problem628.maximumProduct(new int[]{1, 2, 3, 4}));
    }

}
