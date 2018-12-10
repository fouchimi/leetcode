import java.util.*;

public class Problem245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }

        int minDistance = Integer.MAX_VALUE;

        if(word1.equals(word2)) {
            List<Integer> uniqueList = map.get(word1);
            minDistance = process(uniqueList);
        } else {
            List<Integer> firstList = map.get(word1);
            List<Integer> secondList = map.get(word2);

            for(int i = 0; i < firstList.size(); i++) {
                for(int j = 0; j < secondList.size(); j++) {
                    int diff = Math.abs(firstList.get(i) - secondList.get(j));
                    if(diff < minDistance) minDistance = diff;
                }
            }
        }

        return minDistance;
    }

    private int process(List<Integer> list) {
        if(list.size() == 1) return list.get(0);
        int tempMinDistance = Integer.MAX_VALUE;
        int diff;
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                diff = Math.abs(list.get(i) - list.get(j));
                if(diff < tempMinDistance) tempMinDistance = diff;
            }
        }
        return tempMinDistance;
    }

    public static void main(String[] args) {
        Problem245 problem245 = new Problem245();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(problem245.shortestWordDistance(words, "makes", "coding"));
        System.out.println(problem245.shortestWordDistance(words, "makes", "makes"));
    }
}
