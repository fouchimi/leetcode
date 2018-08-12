import java.util.Arrays;

public class Problem280 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length - 1; i+=2)
            swap(nums, i, i + 1);
    }

    void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Problem280 problem280 = new Problem280();
        int[] nums = {3, 5, 2, 1, 6, 4};
        problem280.wiggleSort(nums);
    }
}
