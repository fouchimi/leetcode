public class Problem421 {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int val = nums[i] ^ nums[j];
                max = Math.max(max, val);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem421 problem421 = new Problem421();
        System.out.println(problem421.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
