public class Problem547 {

    class UnionFind {

        int[] parent, rank;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int id) {
            while (parent[id] != id) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void union(int p, int q) {
            int pid = find(p);
            int qid = find(q);
            if (pid == qid) return;
            if(rank[pid] > rank[qid]) {
                parent[qid] = pid;
            } else {
                parent[pid] = qid;
                if(rank[pid] == rank[qid]) rank[qid]++;
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        Problem547 problem547 = new Problem547();
        System.out.println(problem547.findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
    }
}
