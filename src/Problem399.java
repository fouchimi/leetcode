import java.util.*;

public class Problem399 {

    public class Edge {
        private int ch;
        private double c;

        public Edge(int i, double c) {
            this.ch = i;
            this.c = c;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        LinkedList<Edge>[] adj = new LinkedList[26];
        for(int i = 0; i < 26; i++) adj[i] = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for(int i = 0; i < equations.length; i++) {
            String first = equations[i][0], second = equations[i][1];
            int firstIndex = first.charAt(0) - 'a', secondIndex = second.charAt(0) - 'a';
            LinkedList<Edge> firstList = adj[firstIndex], secondList = adj[secondIndex];
            firstList.add(new Edge(secondIndex, values[i]));
            secondList.add(new Edge(firstIndex, 1.0/values[i]));
        }

        double[] res = new double[queries.length];
        for(int i = 0; i < res.length; i++) res[i] = -1.0;

        for(int i = 0; i < queries.length; i++){
            String[] query = queries[i];
            int s = query[0].charAt(0) - 'a';
            int d = query[1].charAt(0) - 'a';
            if(!adj[s].isEmpty() && !adj[d].isEmpty()) dfs(adj, s, d, visited, i, res, 1.0);
        }
        return res;
    }

    private void dfs(LinkedList<Edge>[] adj, int s, int d, boolean[] visited, int index, double[] result, double cost) {
        if(s == d) {
            result[index] = cost;
            return;
        }
        visited[s] = true;
        for(Edge w : adj[s]){
            int i = w.ch;
            if(!visited[i]) dfs(adj, i, d, visited, index, result, cost * w.c);
        }
        visited[s] = false;
    }

    public static void main(String[] args){
        Problem399 problem399 = new Problem399();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        double[] values = {2.0, 3.0};
        double[] result = problem399.calcEquation(equations, values, queries);
        for(double w : result) System.out.print(w + " ");
    }
}
