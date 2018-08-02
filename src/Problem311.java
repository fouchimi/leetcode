public class Problem311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        int row = 0;
        while (row < A.length) {
            int m = 0, col = 0;
            while (m < B[0].length) {
                int prod = 0, k = 0, i = 0;
                while (k < A[0].length && i < B.length) {
                    prod += A[row][k++] * B[i++][m];
                }
                result[row][col] = prod;
                m++;
                col++;
            }
            row++;
        }
        return result;
    }

    public static void main(String[] args){
        Problem311 problem311 = new Problem311();
        //int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        //int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] A = {{1, -5}};
        int[][] B = {{12}, {-1}};
        int[][] C = problem311.multiply(A, B);
        for(int row = 0; row < C.length; row++) {
            for(int col = 0; col < C[0].length; col++) System.out.print(C[row][col] + " ");
            System.out.println();
        }
    }
}
