import java.util.*;

public class Problem210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            int key = pair[1], val = pair[0];
            List<Integer> currentList = map.get(key);
            currentList.add(val);
            map.put(key, currentList);
        }
        boolean[] temp = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int v = 0; v < numCourses; v++) {
            if(!visited[v]) visit(v, map, temp, visited, list, set);
        }
        if(!set.isEmpty()) return new int[0];
        int[] res = new int[numCourses];
        for(int v = 0; v < list.size(); v++) res[v] = list.get(v);
        return res;
    }

    private void visit(int s, Map<Integer, List<Integer>> map, boolean[] temp, boolean[] visited, List<Integer> list, Set<Integer> set){
        if(visited[s]) return;
        if(temp[s]) {
            set.add(s);
            return;
        }
        temp[s] = true;
        for(int w : map.get(s)) {
            visit(w, map, temp, visited, list, set);
        }
        visited[s] = true;
        list.add(0, s);
    }

    public static void main(String[] args) {
        Problem210 problem210 = new Problem210();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = problem210.findOrder(4, prerequisites);
        for(int val : result) {
            System.out.print(val + ", ");
        }
        System.out.println();
    }
}
