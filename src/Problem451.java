import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem451 {

    char[] pq;
    int N = 0;
    public String frequencySort(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }

        pq = new char[map.size() + 1];
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            pq[++N] = pair.getKey();
            swim(map, N);
        }

        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            char ch = pq[1];
            int k = map.get(ch);
            while(k > 0) {
                sb.append(ch);
                k--;
            }
            pq[1] = pq[N--];
            pq[N+1] = '\0';
            sink(map, 1);
        }

        return sb.toString();
    }

    private void sink(Map<Character, Integer> map, int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(map, j, j+1)) j++;
            if(!less(map, k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(Map<Character, Integer> map, int k) {
        while (k > 1 && less(map, k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private boolean less(Map<Character, Integer> map, int p, int q) {
        return map.get(pq[p]) < map.get(pq[q]);
    }

    private void exch(int p, int q) {
        char temp = pq[q];
        pq[q] = pq[p];
        pq[p] = temp;
    }

    public static void main(String[] args) {
        Problem451 problem451 = new Problem451();
        System.out.println(problem451.frequencySort("tree"));
    }
}
