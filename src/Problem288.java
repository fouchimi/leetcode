import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem288 {
    Map<String, List<String>> map;
    public Problem288(String[] dictionary) {
        map = new HashMap<>();
        List<String> list;
        for(String eachWord : dictionary) {
            if(eachWord.length() <= 2) {
                list = new ArrayList<>();
                list.add(eachWord);
                map.put(eachWord, list);
            }
            else {
                int size = eachWord.substring(1, eachWord.length()-1).length();
                String abbr = String.valueOf(eachWord.charAt(0)) + size + eachWord.charAt(eachWord.length()-1);
                if(!map.containsKey(abbr)) {
                    list = new ArrayList<>();
                    list.add(eachWord);
                    map.put(abbr, list);
                } else {
                    list = map.get(abbr);
                    list.add(eachWord);
                    map.put(abbr, list);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        if(word.length() <= 2) {
            if(!map.containsKey(word) || (map.get(word).size() == 1) && map.get(word).get(0).equals(word)) return true;
            else return false;
        } else {
            int size = word.substring(1, word.length()-1).length();
            String abbr = String.valueOf(word.charAt(0)) + size + word.charAt(word.length()-1);
            if(!map.containsKey(abbr) || (map.get(abbr).size() == 1 && map.get(abbr).get(0).equals(word))) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"deer", "door", "cake", "card"};
        Problem288 problem288 = new Problem288(dictionary);
        System.out.println(problem288.isUnique("dear"));
        System.out.println(problem288.isUnique("cart"));
        System.out.println(problem288.isUnique("cane"));
        System.out.println(problem288.isUnique("make"));
    }
}
