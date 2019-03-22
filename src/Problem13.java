import java.util.HashMap;
import java.util.Map;

public class Problem13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = map.get(s.charAt(s.length()-1));
        for(int i = s.length()-1; i > 0; i--) {
            if(map.get(s.charAt(i-1)) >= map.get(s.charAt(i))) sum += map.get(s.charAt(i-1));
            else sum -= map.get(s.charAt(i-1));
        }

        return sum;
    }

    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        System.out.println(problem13.romanToInt("III"));
        System.out.println(problem13.romanToInt("IV"));
        System.out.println(problem13.romanToInt("IX"));
        System.out.println(problem13.romanToInt("LVIII"));
        System.out.println(problem13.romanToInt("MCMXCIV"));
    }
}
