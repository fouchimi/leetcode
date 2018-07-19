import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem266 {

    public boolean canPermutePalindrome(String s) {
        if(s.length() == 1) return true;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        Set<Character> left = new HashSet<>(), right = new HashSet<>(), middle = new HashSet<>();
        for(Character ch : map.keySet()) {
            if(map.get(ch) == 1) middle.add(ch);
            if(isEven(map.get(ch))) {
                left.add(ch);
                right.add(ch);
            }else if(isOdd(map.get(ch))) {
                left.add(ch);
                right.add(ch);
                middle.add(ch);
            }
        }

        return (left.size() == right.size() && middle.size() == 1) || (left.size() == right.size() && middle.isEmpty());
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }

    private boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        Problem266 problem266 = new Problem266();
        System.out.println(problem266.canPermutePalindrome("abc"));
        System.out.println(problem266.canPermutePalindrome("aab"));
        System.out.println(problem266.canPermutePalindrome("carerac"));
    }
}
