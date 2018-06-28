import java.util.HashMap;
import java.util.Map;

public class Problem345 {

    public String reverseVowels(String s) {

        if(s == null || s.isEmpty() || s.length() == 1) return s;
        StringBuilder  firstSb = new StringBuilder(), secondSb = new StringBuilder();
        int i = 0, j = s.length()-1;
        for(; i < j; ) {
            if(isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                firstSb.append(s.charAt(j));
                secondSb.insert(0, s.charAt(i));
                i++;
                j--;
            }else if(isVowel(s.charAt(i)) && !isVowel(s.charAt(j))) {
                secondSb.insert(0, s.charAt(j));
                j--;
            }
            else if(!isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                firstSb.append(s.charAt(i));
                i++;
            }
            else {
                firstSb.append(s.charAt(i));
                secondSb.insert(0, s.charAt(j));
                i++;
                j--;
            }
        }
        if(firstSb.length() + secondSb.length() < s.length()) firstSb.append(s.charAt(i));
        return firstSb.append(secondSb.toString()).toString();
    }

    private boolean isVowel(char c) {
        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'a');
        map.put('e', 'e');
        map.put('i', 'i');
        map.put('o', 'o');
        map.put('u', 'u');
        map.put('A', 'A');
        map.put('E', 'E');
        map.put('I', 'I');
        map.put('O', 'O');
        map.put('U', 'U');
        return map.containsKey(c);
    }

    public static void main(String[] args) {
        Problem345 problem345 = new Problem345();
        System.out.println(problem345.reverseVowels("hello"));
        System.out.println(problem345.reverseVowels("leetcode"));
    }
}
