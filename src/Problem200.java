public class Problem200 {

    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private boolean isSafe(char[][] grid, int row, int col) {
        if(row < 0 || row > grid.length-1  ||
                col < 0 || col > grid[0].length-1 ||
                grid[row][col] == '0' || grid[row][col] == '\0') return false;
        return true;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(isSafe(grid, row, col)) {
            grid[row][col] = '\0';
            dfs(grid, row, col+1);
            dfs(grid, row+1, col);
            dfs(grid, row, col-1);
            dfs(grid, row-1, col);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        Problem200 problem200 = new Problem200();
        System.out.println(problem200.numIslands(grid));
    }
}
