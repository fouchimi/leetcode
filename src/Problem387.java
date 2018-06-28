import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem387 {

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 1);
            else map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            if(pair.getValue() == 1) return s.indexOf(pair.getKey());
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem387 problem387 = new Problem387();
        System.out.println(problem387.firstUniqChar("leetcode"));
    }
}
