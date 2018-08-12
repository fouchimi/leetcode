import java.util.*;

public class Problem399 {

    class Edge {
        private String key;
        private double c;

        Edge(String str, double c) {
            this.key = str;
            this.c = c;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String, List<Edge>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String first = equations[i][0], second = equations[i][1];
            List<Edge> list;
            if(map.containsKey(first)) {
                list = map.get(first);
                list.add(new Edge(second, values[i]));
                map.put(first, list);
                if(map.containsKey(second)) {
                    list = map.get(second);
                    list.add(new Edge(first, 1.0/values[i]));
                    map.put(second, list);
                }else {
                    list = new ArrayList<>();
                    list.add(new Edge(first, 1.0/values[i]));
                    map.put(second, list);
                }
            }else {
                list = new ArrayList<>();
                list.add(new Edge(second, values[i]));
                map.put(first, list);
                if(map.containsKey(second)) {
                    list = map.get(second);
                    list.add(new Edge(first, 1.0/values[i]));
                    map.put(second, list);
                }else {
                    list = new ArrayList<>();
                    list.add(new Edge(first, 1.0/values[i]));
                    map.put(second, list);
                }
            }
        }

        double[] res = new double[queries.length];
        for(int i = 0; i < res.length; i++) res[i] = -1.0;

        Set<String> set = new HashSet<>();
        for(int i = 0; i < queries.length; i++){
            String[] query = queries[i];
            String s = query[0];
            String d = query[1];
            if(!map.containsKey(s)) continue;
            dfs(map, set, s, d, i, res, 1.0);
        }
        return res;
    }

    private void dfs(Map<String, List<Edge>> map, Set<String> set,  String s, String d,  int index, double[] result, double cost) {
        if(s.equals(d)) {
            result[index] = cost;
            return;
        }
        set.add(s);
        for(Edge w : map.get(s))
            if(!set.contains(w.key)) dfs(map, set, w.key, d, index, result, cost * w.c);
        set.remove(s);
    }

    public static void main(String[] args){
        Problem399 problem399 = new Problem399();
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        String[][] queries = { {"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        double[] values = {2.0, 3.0};
        double[] result = problem399.calcEquation(equations, values, queries);
        for(double w : result) System.out.print(w + " ");
    }
}
