public class Problem130 {
    private int m, n;

    private class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0;i < n;i++)    parent[i] = i;
        }
        public int find(int n){
            while(n != parent[n]){
                parent[n] = parent[parent[n]];
                n = parent[n];
            }

            return n;
        }
        public void union(int i, int j){
            int rooti = find(i);
            int rootj = find(j);

            if(rooti == rootj) return;

            if(rank[rootj] < rank[rooti]){
                parent[rootj] = rooti;
            }else{
                parent[rooti] = rootj;
                if(rank[rooti] == rank[rootj]) rank[rootj]++;
            }
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;

        m = board.length;
        n = board[0].length;
        int dummyNode = m * n;
        UnionFind unionFind = new UnionFind(dummyNode + 1);

        for(int i = 0; i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                        unionFind.union(i * n + j, dummyNode);
                    }else{
                        if(j - 1 >= 0 && board[i][j - 1] == 'O')  unionFind.union(getNode(i, j), getNode(i, j - 1));
                        if(i - 1 >= 0 && board[i - 1][j] == 'O')  unionFind.union(getNode(i, j), getNode(i - 1, j));
                        if(i + 1 < m && board[i + 1][j] == 'O')   unionFind.union(getNode(i, j), getNode(i + 1, j));
                        if(j + 1 < n && board[i][j + 1] == 'O')   unionFind.union(getNode(i, j), getNode(i, j + 1));
                    }
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'O'){
                    if(unionFind.find(getNode(i, j)) == unionFind.find(dummyNode)) board[i][j] = 'O';
                    else    board[i][j] = 'X';
                }
            }
        }
    }
    public int getNode(int i, int j){
        return i * n + j;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                          {'X', 'O', 'O', 'X'},
                          {'X', 'X', 'O', 'X'},
                          {'X', 'O', 'X', 'X'}};
        Problem130 problem130 = new Problem130();
        problem130.solve(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
