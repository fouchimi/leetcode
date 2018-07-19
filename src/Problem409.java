import java.util.HashMap;
import java.util.Map;

public class Problem409 {

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }

        int lefCount = 0, rightCount = 0, middleCount = 0;
        for(Character ch : map.keySet()) {
            int freq = map.get(ch);
            if(freq == 1) middleCount++;
            else if(freq % 2 == 0) {
                lefCount += freq /2;
                rightCount += freq /2;
            }else if( freq > 1 && freq % 2 != 0) {
                freq = freq - 1;
                lefCount += freq / 2;
                rightCount += freq / 2;
                middleCount++;
            }
        }
        return middleCount >= 1 ? lefCount + rightCount + 1 : lefCount + rightCount;
    }

    public static void main(String[] args) {
        Problem409 problem409 = new Problem409();
        System.out.println(problem409.longestPalindrome("abccccdd"));
    }
}
