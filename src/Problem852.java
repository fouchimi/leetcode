public class Problem852 {

    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) return -1;
        int i = 1, p = 0, q = 0;
        for(; i < A.length; ) {
            if(A[i-1] < A[i]) i++;
            else {
                p = i-1;
                break;
            }
        }
        i = A.length-1;
        for(; i >= 1; ) {
            if(A[i-1] > A[i]) i--;
            else {
                q = i;
                break;
            }
        }
        if(p == q) return p;
        return -1;
    }

    public static void main(String[] args) {
        Problem852 problem852 = new Problem852();
        System.out.println(problem852.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(problem852.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
