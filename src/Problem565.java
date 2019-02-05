
public class Problem565 {

    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        boolean[] used = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int currentIndex = i, count =0;
            if(used[nums[currentIndex]]) continue;
            while (!used[nums[currentIndex]]) {
                count++;
                used[nums[currentIndex]] = true;
                currentIndex = nums[currentIndex];
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem565 problem565 = new Problem565();
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(problem565.arrayNesting(nums));
    }
}
