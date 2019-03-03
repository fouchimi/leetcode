public class Problem594 {

    public int findLHS(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int posCount = 0, sameCount = 0, negCount = 0;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) sameCount++;
                else if(nums[i] - nums[j] == 1) posCount++;
                else if(nums[i] - nums[j] == -1) negCount++;
            }
            if(posCount > 0) posCount += sameCount;
            if(negCount > 0) negCount += sameCount;
            if(posCount > 0) max = Math.max(max, posCount+1);
            if(negCount > 0) max = Math.max(max, negCount+1);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem594 problem594 = new Problem594();
        //int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums = {1,2,1,3,0,0,2,2,1,3,3};
        //int[] nums = {1, 1, 1, 1};
        System.out.println(problem594.findLHS(nums));
    }

}
