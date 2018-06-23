import java.util.ArrayList;
import java.util.List;

public class Problem695 {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 && grid[0].length == 1) return grid[0][0];
        int maxArea = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, list);
                    maxArea = Math.max(maxArea, list.size());
                    list.clear();
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int row, int col, List<Integer> list) {
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || grid[row][col] == 0 || grid[row][col] == -1) return;
        else {
            list.add(grid[row][col]);
            grid[row][col] = -1;
            dfs(grid, row, col+1, list);
            dfs(grid, row+1, col, list);
            dfs(grid, row, col-1, list);
            dfs(grid, row-1, col, list);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        Problem695 problem695 = new Problem695();
        System.out.println(problem695.maxAreaOfIsland(grid));
    }
}
