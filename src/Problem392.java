import java.util.LinkedList;
import java.util.Queue;

public class Problem392 {

    public boolean isSubsequence(String s, String t) {

        if(s == null || t == null || s.isEmpty() || t.isEmpty()) return false;

        int n = s.length();
        int m = t.length();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        char ch = s.charAt(0);
        while (!queue.isEmpty()) {
            int k = 0, index = queue.poll();
            for(int i = index; i < m; i++) {
                if(k < n && s.charAt(k) == t.charAt(i)) k++;
                if(t.charAt(i) == ch && i > index && m-i >= n) queue.add(i);
            }
            if(k == n) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Problem392 problem392 = new Problem392();
        System.out.println(problem392.isSubsequence("abc", "ahbgdc"));
    }
}
