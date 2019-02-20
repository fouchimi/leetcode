import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem720 {
    Set<String> set;
    public String longestWord(String[] words) {
        set = new HashSet<>();
        Arrays.sort(words);
        for(String word : words){
            set.add(word);
        }
        int maxLen = 0;
        String ans = "";
        for(String word : words){
            if(helper(word) && word.length() > maxLen){
                maxLen = word.length();
                ans = word;
            }
        }
        return ans;
    }
    private boolean helper(String word){
        String s = "";
        for(char c : word.toCharArray()){
            s += c;
            if(!set.contains(s)){
                return false;
            }
        }
        return true;
    }

//    TrieNode root = new TrieNode();
//    String[] res = new String[2];
//
//    class TrieNode {
//        char ch;
//        TrieNode[] children = new TrieNode[128];
//    }
//
//    public String longestWord(String[] words) {
//        Arrays.sort(words);
//        res[0] = "";
//        res[1] = "";
//        for(String word : words) insertWord(word);
//        return res[1].length() - res[0].length() == 1 ? res[1] : res[0];
//    }
//
//    private void insertWord(String word) {
//        root = insertWord(root, word, 0, "");
//    }
//
//    private TrieNode insertWord(TrieNode x, String word, int d, String prefix) {
//        if(x == null) x = new TrieNode();
//        if(d == word.length()) return x;
//        char ch = word.charAt(d);
//        if(x.children[ch] != null) {
//            prefix += ch;
//            if(prefix.length() > res[0].length() || (prefix.length() == res[0].length() && prefix.compareTo(res[0]) < 0)) {
//                res[0] = prefix;
//                res[1] = word;
//            }
//        }
//        x.children[ch] = insertWord(x.children[ch], word, d+1, prefix);
//        return x;
//    }

    public static void main(String[] args) {
        Problem720 problem720 = new Problem720();
        //String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        //String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(problem720.longestWord(words));
    }
}
