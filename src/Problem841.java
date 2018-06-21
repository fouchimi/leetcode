import java.util.*;

public class Problem841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> vertices = new HashSet<>();
        for(int i = 0; i < rooms.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < rooms.get(i).size(); j++){
                list.add(rooms.get(i).get(j));
                vertices.add(rooms.get(i).get(j));
            }
            map.put(i, list);
        }
        Iterator itr =  map.entrySet().iterator();
        List<Integer> visited = new ArrayList<>();
        while (itr.hasNext()) {
            Map.Entry<Integer, List<Integer>> pair = (Map.Entry<Integer, List<Integer>>) itr.next();
            dfs(pair.getKey(), map, visited);
            break;
        }

        Iterator it = vertices.iterator();
        while (it.hasNext()) {
            if(!visited.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int s, Map<Integer, List<Integer>> map, List<Integer> visited) {
        List<Integer> neighbors = map.get(s);
        if(neighbors != null){
            for(int v: neighbors) {
                if(!visited.contains(v)){
                    visited.add(v);
                    dfs(v, map, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(3);
        List<Integer> secondList = new ArrayList<>();
        secondList.add(3);
        secondList.add(0);
        secondList.add(1);
        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(2);
        List<Integer> fourthList = new ArrayList<>();
        fourthList.add(0);
        List<List<Integer>> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(thirdList);
        list.add(fourthList);
        Problem841 problem841  = new Problem841();
        System.out.println(problem841.canVisitAllRooms(list));
    }
}
