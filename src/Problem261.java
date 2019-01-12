import java.util.*;

public class Problem261 {

    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0 && n == 1) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int[] edge : edges) {
            if(!map.containsKey(edge[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            } else map.get(edge[0]).add(edge[1]);

            if(!parentMap.containsKey(edge[1])) {
                List<Integer> parentList = new ArrayList<>();
                parentList.add(edge[0]);
                parentMap.put(edge[1], parentList);
            } else parentMap.get(edge[1]).add(edge[0]);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            if(!visited[key]) {
                if(!dfs(key, map, visited, parentMap)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int s, Map<Integer, List<Integer>> adj, boolean[] visited, Map<Integer, List<Integer>> parentMap) {
        visited[s] = true;
        List<Integer> list = adj.get(s);
        if(list != null) {
            for(int w : list) {
                if(!visited[w]) {
                    if(!dfs(w, adj, visited, parentMap)) {
                        return false;
                    }
                } else if(parentMap.get(w) != null && parentMap.get(w).contains(s)) {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int n = 3;
        //int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        //int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        //int[][] edges = {{1,0},{0,2},{2,1}};
        int[][] edges = {{1, 0}, {2, 0}};
        Problem261 problem261 = new Problem261();
        System.out.println(problem261.validTree(n, edges));
    }
}
