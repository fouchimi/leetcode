import java.util.HashMap;
import java.util.Map;

public class Problem261 {

    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = -1;
        for(int[] edge : edges) {

            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if(x == y) return false;
            union(parent, x, y);
        }

        Map<Integer, Integer> map =new HashMap<>();
        for(int i = 0; i < n; i++) {
            int p = find(parent, i);
            if(p == i) map.put(p, i);
            else map.put(p, i);
        }

        return map.size() == 1;
    }

    private int find(int[] parent, int val) {
        if(parent[val] == -1) {
            return val;
        }
        return find(parent, parent[val]);
    }

    private void union(int[] parent, int x, int y) {
        int x_root = find(parent, x);
        int y_root = find(parent, y);
        parent[x_root] = y_root;
    }

    public static void main(String[] args) {
        int n = 4;
        //int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        //int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        //int[][] edges = {{1,0},{0,2},{2,1}};
        //int[][] edges = {{1, 0}, {2, 0}};
        int[][] edges = {{0,1}, {2, 3}};
        Problem261 problem261 = new Problem261();
        System.out.println(problem261.validTree(n, edges));
    }
}
