public class Problem378 {

    int N = 0;
    public int kthSmallest(int[][] matrix, int k) {

        int[] pq = new int[(matrix.length * matrix[0].length) + 1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq[++N] = matrix[i][j];
                swim(pq, N);
            }
        }

        int currentMin = Integer.MIN_VALUE;
        while (k > 0) {
            currentMin = pq[1];
            pq[1] = pq[N--];
            pq[N+1] = Integer.MIN_VALUE;
            sink(pq, 1);
            k--;
        }

        return currentMin;
    }

    private void sink(int[] pq, int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(pq, j+1, j)) j++;
            if(!less(pq, j, k)) break;
            exch(pq, j, k);
            k = j;
        }
    }

    private void swim(int[] pq, int k) {
        while (k > 1 && less(pq, k, k/2)) {
            exch(pq, k/2, k);
            k = k/2;
        }
    }

    private boolean less(int[] pq, int p, int q) {
        return pq[p] < pq[q];
    }

    private void exch(int[] pq, int p, int q) {
        int temp = pq[q];
        pq[q] = pq[p];
        pq[p] = temp;
    }

    public static void main(String[] args) {
        Problem378 problem378 = new Problem378();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {9, 13, 15}};
        System.out.println(problem378.kthSmallest(matrix, 8));
    }
}
