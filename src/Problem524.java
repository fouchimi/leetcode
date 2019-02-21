import java.util.ArrayList;
import java.util.List;

public class Problem524 {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int N = s.length();
        for(String word : d) {
            int M = word.length(), j = 0, i = 0;
            while (i < N && j < M) {
                if(s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            if((j == word.length())){
                if(word.length() > res.length() ||
                        (word.length() == res.length() &&  word.compareTo(res) < 0)) res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem524 problem524 = new Problem524();
        //String word = "abpcplea";
        String word = "aewfafwafjlwajflwajflwafj";
        //String word = "bab";
        List<String> list = new ArrayList<>();
//        list.add("ale");
//        list.add("apple");
//        list.add("monkey");
//        list.add("plea");
//        list.add("ba");
//        list.add("ab");
//        list.add("a");
//        list.add("b");
        list.add("apple");
        list.add("ewaf");
        list.add("awefawfwaf");
        list.add("awef");
        list.add("awefe");
        list.add("ewafeffewafewf");
        System.out.println(problem524.findLongestWord(word, list));
    }
}
