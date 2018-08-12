public class Problem733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        boolean[][] visited = new boolean[image.length][image[0].length];

        dfs(image, sr, sc, sr, sc, visited);

        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                if(visited[i][j]) image[i][j] = newColor;
            }
        }

        return image;
    }

    private void dfs(int[][] image, int row, int col, int sr, int sc, boolean[][] visited){
        if(isValid(image, row, col, sr, sc) && !visited[row][col]) {
            visited[row][col] = true;
            dfs(image, row-1, col, sr, sc, visited);
            dfs(image, row, col-1, sr, sc,  visited);
            dfs(image, row+1, col, sr, sc,  visited);
            dfs(image, row, col+1, sr, sc, visited);
        }
    }

    private boolean isValid(int[][] image, int row, int col, int sr, int sc) {
        if(row < 0 || col < 0 || row > image.length-1 || col > image[0].length-1 || image[row][col] != image[sr][sc]) return false;
        return true;
    }

    public static void main(String[] args) {
        Problem733 problem733 = new Problem733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = problem733.floodFill(image, 1, 1, 2);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
