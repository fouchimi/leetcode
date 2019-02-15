public class Problem941 {

    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        int up = 0, down = 0, i = 1;
        while (i < A.length) {
            if(A[i-1] < A[i]) i++;
            else if(A[i-1] == A[i]) return false;
            else break;
            up++;
        }

        while (i < A.length) {
            if(A[i-1] > A[i]) {
                i++;
                down++;
            }
            else return false;
        }

        return up > 0 && down > 0 && i == A.length;
    }

    public  static void main(String[] args) {
        Problem941 problem941 = new Problem941();
        System.out.println(problem941.validMountainArray(new int[]{2, 1}));
        System.out.println(problem941.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(problem941.validMountainArray(new int[]{0, 3, 2, 1}));
    }

}
