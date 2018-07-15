import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem692 {

    int N = 0;
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new LinkedHashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) map.put(word, map.get(word)+1);
            else map.put(word, 1);
        }

        String[] pq = new String[map.size() + 1];
        for(String key : map.keySet()) {
            pq[++N] = key;
            swim(pq, map, N);
        }

        List<String> list = new ArrayList<>();
        while (k > 0 && N > 0) {
            list.add(pq[1]);
            pq[1] = pq[N--];
            pq[N+1] = null;
            sink(pq, map, 1);
            k--;
        }

        return list;
    }

    private void sink(String[] pq, Map<String, Integer> map, int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(pq, map, j, j+1)) j++;
            if(!less(pq, map, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private void swim(String[] pq, Map<String, Integer> map, int k) {
        while (k > 1 && less(pq, map, k/2, k)) {
            exch(pq, k/2, k);
            k = k/2;
        }
    }

    private boolean less(String[] pq, Map<String, Integer> map, int p, int q) {
        if(map.get(pq[p]) != null && map.get(pq[q]) != null && map.get(pq[p]) < map.get(pq[q])) return true;
        else if(map.get(pq[p]) != null && map.get(pq[q]) != null && map.get(pq[p]).equals(map.get(pq[q]))) return pq[q].compareTo(pq[p]) < 0;
        return false;
    }

    private void exch(String[] pq, int p, int q) {
        String temp = pq[q];
        pq[q] = pq[p];
        pq[p] = temp;
    }

    public static void main(String[] args) {
        Problem692 problem692 = new Problem692();
        /*String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(problem692.topKFrequent(words, 2)); */
        /*String[] wordList = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(problem692.topKFrequent(wordList, 4)); */
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(problem692.topKFrequent(words, 3));
    }
}
