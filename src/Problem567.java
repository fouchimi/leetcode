import java.util.HashMap;
import java.util.Map;

public class Problem567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int M = s1.length();
        for(int i = 0; i < M; i++) {
            char ch = s1.charAt(i);
            if(!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch)+1);
        }

        int N = s2.length();
        for(int i = 0; i <= N-M; i++) {
            String subStr = s2.substring(i, i + M);
            if(isIncluded(subStr, map)) return true;
        }
        return false;
    }

    private boolean isIncluded(String str, Map<Character, Integer> map) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!tempMap.containsKey(ch)) tempMap.put(ch, 1);
            else tempMap.put(ch, tempMap.get(ch)+1);
        }

        for(Character key : tempMap.keySet()) {
            if(!map.containsKey(key) || !map.get(key).equals(tempMap.get(key))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem567 problem567 = new Problem567();
        //System.out.println(problem567.checkInclusion("adc", "dcda"));
        System.out.println(problem567.checkInclusion("hello", "ooolleoooleh"));
    }
}
