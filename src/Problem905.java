public class Problem905 {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int p = 0, q = A.length-1;
        for(int i = 0; i < A.length; i++) {
            if(A[i]%2 == 0) res[p++] = A[i];
            else res[q--] = A[i];
        }
        return res;
    }

    public void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem905 problem905 = new Problem905();
        int[] nums = new int[] {3, 1, 2, 4};
        problem905.sortArrayByParity(nums);
        problem905.print(nums);
    }
}
