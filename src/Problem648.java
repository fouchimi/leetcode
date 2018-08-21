import java.util.ArrayList;
import java.util.List;

public class Problem648 {

    Trie root = new Trie();
    private static final int R = 26;

    class Trie {
        String val;
        Trie[] next = new Trie[R];

        Trie(){}

        Trie(String v) {
            this.val = v;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        for(String word : dict) add(word);
        String[] words = sentence.split(" ");
        List<String> list = new ArrayList<>();
        for(String word : words) check(word, list);
        StringBuilder output = new StringBuilder();
        for(String word : list) output.append(word).append(" ");
        return output.toString().trim();
    }

    private void check(String value, List<String> list) {
        root = check(root, value, 0, list);
    }

    private Trie check(Trie x, String value, int d, List<String> list) {
        if(x == null) x = new Trie();
        if(d == value.length()) {
            list.add(value);
            return x;
        }else if(x.val != null) {
            list.add(x.val);
            return x;
        }
        int index = value.charAt(d) - 'a';
        x.next[index] = check(x.next[index], value, d+1, list);
        return x;
    }

    private void add(String value) {
        root = add(root, value, 0);
    }

    private Trie add(Trie x, String value, int d) {
        if(x == null) x = new Trie();
        if(d == value.length()) {
            x = new Trie(value);
            return x;
        }
        int index = value.charAt(d)-'a';
        x.next[index] = add(x.next[index], value, d+1);
        return x;
    }

    public static void main(String[] args){
        Problem648 problem648 = new Problem648();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");

        String sentence = "the cattle was rattle by the battery";
        System.out.println(problem648.replaceWords(dict, sentence));

    }

}
