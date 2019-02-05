import java.util.LinkedHashMap;
import java.util.Map;

public class Problem443 {

    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        if(chars.length == 1) return 1;
        Map<Character, Integer> map = new LinkedHashMap<>();
        char prev = chars[0];
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < chars.length; i++) {
            if(prev == chars[i]) count++;
            else {
                if(count == 1) sb.append(prev);
                else sb.append(prev).append(count);
                prev = chars[i];
                count = 1;
            }
        }
        if(count == 1) sb.append(prev);
        else sb.append(prev).append(count);
        String str = sb.toString();
        for(int i = 0; i < str.length(); i++) chars[i] = str.charAt(i);
        return str.length();
    }

    public static void main(String[] args) {
        Problem443 problem443 = new Problem443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(problem443.compress(chars));
        char[] chars1 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(problem443.compress(chars1));
        char[] chars2 = {'a'};
        System.out.println(problem443.compress(chars2));
        char[] chars3 = {'a','a','a','b','b','a','a'};
        System.out.println(problem443.compress(chars3));
        char[] chars4 = {'a', 'a'};
        System.out.println(problem443.compress(chars4));
        char[] chars5 = {'a', 'b', 'c'};
        System.out.println(problem443.compress(chars5));
    }
}
