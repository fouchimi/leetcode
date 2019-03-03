import java.util.*;

public class Problem249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') c += 26;
                sb.append(c);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem249 problem249 = new Problem249();
        //String[] strings = {"ab", "ba"};
        String[] strings = {"abc", "bcd", "def", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> res = problem249.groupStrings(strings);
        for(List<String> list : res) System.out.println(list);
    }
}
