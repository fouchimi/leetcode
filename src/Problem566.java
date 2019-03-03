public class Problem566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int rows = nums.length;
        int cols = nums[0].length;
        int m = 0, n = 0;

        if(r * c > rows * cols) return nums;

        int[][] result = new int[r][c];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(n == c) {
                    m++;
                    n = 0;
                }
                result[m][n] = nums[i][j];
                n++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem566 problem566 = new Problem566();
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        int[][] result = problem566.matrixReshape(nums, r, c);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
