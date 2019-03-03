
public class Problem323 {

    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        for(int[] e : edges) {
            int x_parent = find(parent, e[0]);
            int y_parent = find(parent, e[1]);
            if(x_parent != y_parent) {
                parent[x_parent] = y_parent;
                n--;
            }
        }
        return n;
    }

    private int find(int[] parent, int id) {
        while (parent[id] != id) {
            parent[id] = parent[parent[id]];
            id = parent[id];
        }
        return id;
    }


    public static void main(String[] args) {
        Problem323 problem323 = new Problem323();
        System.out.println(problem323.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}
