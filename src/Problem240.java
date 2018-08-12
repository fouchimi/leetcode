public class Problem240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        for(int row = 0; row < matrix.length; row++) {
            int[] currentRow = matrix[row];
            if(target >= currentRow[0] && target <= currentRow[matrix[0].length-1]) {
                if(binarySearch(currentRow, 0, matrix[0].length-1, target) > -1) return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] row, int lo, int hi, int target) {
        if(lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(target == row[mid]) return mid;
        else if(target < row[mid]) return binarySearch(row, lo, mid-1 ,target);
        else return binarySearch(row, mid+1, hi, target);
    }

    public static void main(String[] args){
        Problem240 problem240 = new Problem240();
        int[][] maxtrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
             };

        System.out.println(problem240.searchMatrix(maxtrix, 5));
        System.out.println(problem240.searchMatrix(maxtrix, 20));
    }

}
