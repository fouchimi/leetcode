import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem243 {

    public int shortestDistance(String[] words, String word1, String word2) {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            }else {
                list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }

        List<Integer> firstList = map.get(word1);
        List<Integer> secondList = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int w : firstList) {
            for(int x : secondList) {
                min = Math.min(min, Math.abs(w - x));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Problem243 problem243 = new Problem243();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(problem243.shortestDistance(words, "coding", "practice"));
        System.out.println(problem243.shortestDistance(words, "makes", "coding"));
    }
}
