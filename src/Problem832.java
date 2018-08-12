public class Problem832 {

    public int[][] flipAndInvertImage(int[][] A) {
        for(int row = 0; row < A.length; row++) {
            int[] tempArr = new int[A[0].length];
            int k = 0;
            for(int col = A[0].length-1; col >=0; col--)
                tempArr[k++] = A[row][col];
            for(int col = 0; col < A[0].length; col++)
                A[row][col] = tempArr[col];
        }

        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < A[0].length; col++) {
                if(A[row][col] == 0) A[row][col] = 1;
                else A[row][col] = 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Problem832 problem832 = new Problem832();
        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] result = problem832.flipAndInvertImage(A);
        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[0].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }
}
