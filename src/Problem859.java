import java.util.HashMap;
import java.util.Map;

public class Problem859 {

    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        char[] strA = A.toCharArray();
        char[] strB = B.toCharArray();
        int p = -1, q = -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < strA.length; i++) {
            if(strA[i] != strB[i] && p ==  -1) p = i;
            else if(strA[i] != strB[i] && q == -1) q = i;
            if(p > -1 && q > -1) break;
            map.put(strA[i], map.getOrDefault(strA[i], 0)+1);
        }
        if(p > -1 && q > -1) {
            char tempCh = strA[p];
            strA[p] = strA[q];
            strA[q] = tempCh;
            String first = String.valueOf(strA);
            String second = String.valueOf(strB);
            return first.equals(second);
        } else {
            for(Character key : map.keySet()) {
                if(map.get(key) > 1) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Problem859 problem859 = new Problem859();
        System.out.println(problem859.buddyStrings("ab", "ba"));
        System.out.println(problem859.buddyStrings("ab", "ab"));
        System.out.println(problem859.buddyStrings("aa", "aa"));
        System.out.println(problem859.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(problem859.buddyStrings("", "aa"));
    }
}
