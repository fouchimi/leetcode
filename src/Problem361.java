public class Problem361 {

    public int maxKilledEnemies(char[][] grid) {
        int maxEnemiesSum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') maxEnemiesSum = Math.max(maxEnemiesSum, countEnemies(grid, i, j));
            }
        }
        return maxEnemiesSum;
    }
    private int countEnemies(char[][] grid, int row, int col) {
        int count = 0;
        // Go left;
        int leftIndex = col, rightIndex = col;
        while (leftIndex >= 0) {
            char ch = grid[row][leftIndex];
            if(ch == 'E') count++;
            else if(ch == 'W') break;
            leftIndex--;
        }
        // Go right
        while (rightIndex < grid[0].length) {
            char ch = grid[row][rightIndex];
            if(ch == 'E') count++;
            else if(ch == 'W') break;
            rightIndex++;
        }
        int topIndex = row, bottomIndex = row;
        // Go up
        while (topIndex >= 0) {
            char ch = grid[topIndex][col];
            if(ch == 'E') count++;
            else if(ch == 'W') break;
            topIndex--;
        }

        // Go Down
        while (bottomIndex < grid.length) {
            char ch = grid[bottomIndex][col];
            if(ch == 'E') count++;
            else if(ch == 'W') break;
            bottomIndex++;
        }

        return count;
    }

    public static void main(String[] args) {
        Problem361 problem361 = new Problem361();
        char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println(problem361.maxKilledEnemies(grid));
    }
}
