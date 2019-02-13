
public class Problem542 {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1) {
                    boolean[][] visited = new boolean[rows][cols];
                    res[i][j] = dfs(matrix, i, j, visited);
                }
            }
        }
        return res;
    }

    private boolean isValid(int[][] matrix, int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row > matrix.length-1  || col > matrix[0].length-1 || visited[row][col]) return false;
        return true;
    }

    private int dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if(matrix[row][col] == 0) return 0;
        visited[row][col] = true;
        int top = 0, left = 0, right = 0, bottom = 0, min = Integer.MAX_VALUE;
        if(isValid(matrix, row-1, col, visited)) top += dfs(matrix, row-1, col, visited) + 1;
        if(isValid(matrix, row, col-1, visited)) left += dfs(matrix, row, col-1, visited) + 1;
        if(isValid(matrix, row, col+1, visited)) right += dfs(matrix, row, col+1, visited) + 1;
        if(isValid(matrix, row+1, col, visited)) bottom += dfs(matrix, row+1, col, visited) + 1;

        visited[row][col] = false;

        if(top > 0) min = Math.min(min, top);
        if(left > 0) min = Math.min(min, left);
        if(right > 0) min = Math.min(min, right);
        if(bottom > 0) min = Math.min(min, bottom);
        return min;
    }


    private void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Problem542 problem542 = new Problem542();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = problem542.updateMatrix(matrix);
        problem542.print(res);
    }
}
