import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionUtil(s, 0, new ArrayList<>(), res);
        for(List<String> eachList : res) System.out.println(eachList);
        return res;
    }

    private void partitionUtil(String s, int k,  List<String> list, List<List<String>> res) {
        if(k == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = k; i < s.length(); i++) {
            if(isPalindrome(s, k, i)) {
                list.add(s.substring(k, i+1));
                partitionUtil(s, i+1, list, res);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem131 problem131 = new Problem131();
        problem131.partition("aab");
    }
}
