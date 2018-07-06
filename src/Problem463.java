import java.util.HashMap;
import java.util.Map;

public class Problem463 {

    public int islandPerimeter(int[][] grid) {
        int entry = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int counter = 0;
                    if(isBorder(grid, i-1, j)) counter++;
                    if(isBorder(grid, i, j-1)) counter++;
                    if(isBorder(grid, i+1, j)) counter++;
                    if(isBorder(grid, i, j+1)) counter++;
                    map.put(entry++, counter);
                }
            }
        }

        int sum = 0;
        for(Integer key: map.keySet()) sum += map.get(key);

        return sum;
    }

    private boolean isBorder(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || grid[row][col] == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Problem463 problem463 = new Problem463();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(problem463.islandPerimeter(grid));
    }
}
