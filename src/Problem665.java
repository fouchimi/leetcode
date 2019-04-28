public class Problem665 {

    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                if (modified) return false;
                else {
                    if (i > 0 && nums[i - 1] > nums[i + 1]) nums[i + 1] = nums[i];
                    modified = true;
                }
        return true;
    }

    public static void main(String[] args) {
        Problem665 problem665 = new Problem665();
        int[] nums = {4, 2, 3};
        System.out.println(problem665.checkPossibility(nums));
        int[] vals = {4, 2, 1};
        System.out.println(problem665.checkPossibility(vals));
        int[] nums1 = {-1, 4, 2, 3};
        System.out.println(problem665.checkPossibility(nums1));
    }
}
