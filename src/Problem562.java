public class Problem562 {

    public int longestLine(int[][] M) {
        int max = 0;
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1) {
                    max = Math.max(max, Math.max(right(M, i, j), Math.max(down(M, i, j), Math.max(diagonal(M, i, j), antiDiagonal(M, i, j)))));
                }
            }
        }
        return max;
    }

    private int right(int[][] M, int row, int col) {
        int count = 0;
        while (col < M[0].length && M[row][col] == 1) {
            count++;
            col++;
        }
        return count;
    }

    private int down(int[][] M, int row, int col) {
        int count = 0;
        while (row < M.length && M[row][col] == 1) {
            count++;
            row++;
        }
        return count;
    }

    private int diagonal(int[][] M, int row, int col) {
        int count = 0;
        while (row < M.length && col < M[0].length && M[row][col] == 1) {
            count++;
            row++;
            col++;
        }
        return count;
    }

    private int antiDiagonal(int[][] M, int row, int col) {
        int count = 0;
        while(row < M.length && col >= 0  && M[row][col] == 1) {
            count++;
            row++;
            col--;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem562 problem562 = new Problem562();
        int[][] matrix = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        System.out.println(problem562.longestLine(matrix));
    }

}
