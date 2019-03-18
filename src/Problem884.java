import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem884 {

    public String[] uncommonFromSentences(String A, String B) {
        if(A == null &&  B == null) return null;
        if(A == null || A.length() == 0) return B.split(" ");
        if(B == null || B.length() == 0) return A.split(" ");

        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> secondMap = new HashMap<>();

        for(String word : wordsA) firstMap.put(word, firstMap.getOrDefault(word, 0)+1);
        for(String word : wordsB) secondMap.put(word, secondMap.getOrDefault(word, 0)+1);

        List<String> uniqueList = new ArrayList<>();
        for(String key : firstMap.keySet()) {
            if(!secondMap.containsKey(key) && firstMap.get(key) == 1) {
                uniqueList.add(key);
            } else secondMap.remove(key);
        }
        for(String key : secondMap.keySet()) {
            if(secondMap.get(key) == 1) uniqueList.add(key);
        }

        String[] ans = new String[uniqueList.size()];
        return uniqueList.toArray(ans);
    }

    public static void main(String[] args) {
        Problem884 problem884 = new Problem884();
        String A = "this apple is sweet";
        String B = "this apple is sour";

        String[] answer = problem884.uncommonFromSentences(A, B);
        for(String str : answer) {
            System.out.print(str + " ");
        }

        System.out.println();

        A = "apple apple";
        B = "banana";

        answer = problem884.uncommonFromSentences(A, B);
        for(String str : answer) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
