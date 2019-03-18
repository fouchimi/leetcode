public class Problem704 {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int lo, int hi, int target) {
        if(lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return search(nums, lo, mid-1, target);
        else return search(nums, mid+1, hi, target);
    }

    public static void main(String[] args) {
        Problem704 problem704 = new Problem704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(problem704.search(nums, 9));
        System.out.println(problem704.search(nums, 2));
    }
}
