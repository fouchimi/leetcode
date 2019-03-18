public class Problem896 {
    public boolean isMonotonic(int[] A) {
        if(A.length == 0) return false;
        if(A.length == 1) return true;

        boolean isIncreasing = true;
        for(int i = 1; i < A.length; i++) {
            if(A[i-1] > A[i]) {
                isIncreasing = false;
                break;
            }
        }
        boolean isDecreasing = true;
        for(int i = 1; i < A.length; i++) {
            if(A[i-1] < A[i]) {
                isDecreasing = false;
                break;
            }
        }
        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        Problem896 problem896 = new Problem896();
        int[] nums1 = new int[] {1, 3, 2};
        System.out.println(problem896.isMonotonic(nums1));
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        System.out.println( problem896.isMonotonic(nums2));
        int[] nums3  = new int[]{1, 1, 1};
        System.out.println(problem896.isMonotonic(nums3));
    }
}
