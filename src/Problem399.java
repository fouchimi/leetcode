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
            String first = equations[i][0];
            String second = equations[i][1];
            int firstIndex = first.charAt(0) - '0', secondIndex = second.charAt(0) - '0';
            LinkedList<Edge> firstList = adj[firstIndex];
            LinkedList<Edge> secondList = adj[secondIndex];
            firstList.add(new Edge(secondIndex, values[i]));
            secondList.add(new Edge(firstIndex, 1.0/values[i]));
        }

        return null;
    }
}
