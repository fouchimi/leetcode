import java.util.*;

public class Problem582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        int key = 0, val = 0;
        for(int i = 0; i < ppid.size(); i++) {
            key = ppid.get(i);
            if(!map.containsKey(key)) {
                val = pid.get(i);
                list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            } else {
                val = pid.get(i);
                list = map.get(key);
                list.add(val);
                map.put(key, list);
            }
        }

        List<Integer> result = new ArrayList<>();
        if(!map.containsKey(kill)){
            result.add(kill);
            return result;
        }
        else {
            Set<Integer> visited = new HashSet<>();
            return dfs(kill, map, result, visited);
        }
    }

    private List<Integer> dfs(int s, Map<Integer, List<Integer>> map, List<Integer> res, Set<Integer> visited){
        if(!visited.contains(s)){
            visited.add(s);
            res.add(s);
            List<Integer> processes = map.get(s);
            if(processes == null) return null;
            for(int w : processes)
                dfs(w, map, res, visited);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem582 problem582 = new Problem582();
        List<Integer> pid = new ArrayList<>();
        pid.add(1);
        pid.add(3);
        pid.add(10);
        pid.add(5);
        List<Integer> ppid = new ArrayList<>();
       ppid.add(3);
        ppid.add(0);
        ppid.add(5);
        ppid.add(3);
        List<Integer> res = problem582.killProcess(pid, ppid, 1);
        for(int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
