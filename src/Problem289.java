public class Problem289 {

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] res = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int count = 0;
                if(isValid(board, i-1, j)) count++;
                //Left neighbor
                if(isValid(board, i, j-1)) count++;
                //Right neighbor
                if(isValid(board, i, j+1)) count++;
                //Bottom neighbor
                if(isValid(board, i+1, j)) count++;
                //Top left neighbor
                if(isValid(board, i-1, j-1)) count++;
                //Top right neighbor
                if(isValid(board, i-1, j+1)) count++;
                //Bottom left neighbor
                if(isValid(board, i+1, j-1)) count++;
                //Bottom right neighbor
                if(isValid(board, i+1, j+1)) count++;

                if(board[i][j] == 0) {
                    if(count == 3) res[i][j] = 1;
                    else res[i][j] = 0;
                }
                else {
                    if(count < 2 || count > 3) res[i][j] = 0;
                    else res[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private boolean isValid(int[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1) return false;
        return board[i][j] == 1;
    }

    private void print(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Problem289 problem289 = new Problem289();
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        problem289.gameOfLife(board);
        problem289.print(board);
    }
}
