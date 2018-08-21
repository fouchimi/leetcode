import java.util.HashMap;
import java.util.Map;

public class Problem771 {

    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> firstMap = new HashMap<>();
        for(int i = 0; i < S.length(); i++) firstMap.put(S.charAt(i), firstMap.getOrDefault(S.charAt(i), 0)+1);
        int count = 0;
        for(int i = 0; i < J.length(); i++) {
            if(firstMap.containsKey(J.charAt(i))) count += firstMap.get(J.charAt(i));
        }
        return count;
    }

    public static void main(String[] args){
        Problem771 problem771 = new Problem771();
        System.out.println(problem771.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(problem771.numJewelsInStones("z", "ZZ"));
    }
}
