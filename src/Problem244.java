import java.util.*;

public class Problem244 {

    Map<String, List<Integer>> map;

    Problem244(String[] words) {
        map = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> firstList = map.get(word1);
        List<Integer> secondList = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < firstList.size(); i++) {
            for(int j = 0; j < secondList.size(); j++) {
                int diff  = Math.abs(firstList.get(i) - secondList.get(j));
                if(diff < minDistance) minDistance = diff;
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        Problem244 problem244 = new Problem244(words);
        System.out.println(problem244.shortest("coding", "practice"));
        System.out.println(problem244.shortest("makes", "coding"));
    }
}
