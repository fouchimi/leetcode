import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();

        for(int i = 0; i < ransomNote.length(); i++) {
            if(!first.containsKey(ransomNote.charAt(i))) first.put(ransomNote.charAt(i), 1);
            else first.put(ransomNote.charAt(i), first.get(ransomNote.charAt(i))+1);
        }

        for(int i = 0; i < magazine.length(); i++) {
            if(!second.containsKey(magazine.charAt(i))) second.put(magazine.charAt(i), 1);
            else second.put(magazine.charAt(i), second.get(magazine.charAt(i))+1);
        }

        Iterator itr = first.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            if(!second.containsKey(pair.getKey()) || second.get(pair.getKey()) <  pair.getValue()) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Problem383 problem383 = new Problem383();
        System.out.println(problem383.canConstruct("a", "b"));
        System.out.println(problem383.canConstruct("aa", "ab"));
        System.out.println(problem383.canConstruct("aa", "aab"));
    }
}
