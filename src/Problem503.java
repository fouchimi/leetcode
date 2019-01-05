public class Problem503 {

    public int[] nextGreaterElements(int[] nums) {
        int  N = nums.length;
        int[] ans = new int[N];
        for(int i = 0; i < N; i++) {
            boolean found = false;
            int j = i+1;
            while (j <= N) {
                j = j % N;
                if(nums[j] > nums[i]) {
                    found = true;
                    break;
                }
                if(j == i) break;
                j++;
            }
            if(found) ans[i] = nums[j];
            else ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem503 problem503 = new Problem503();
        int[] nums = {1, 2, 1};
        int[] ans = problem503.nextGreaterElements(nums);
        for(int val : ans) System.out.print(val + " ");
    }
}
