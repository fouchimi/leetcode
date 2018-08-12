
public class Problem459 {

    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.isEmpty() || s.length() == 1) return false;

        for(int i = 1; i < s.length(); i++) {
            String temp = s;
            String needle = temp.substring(0, i);
            while (needle.length() <= temp.length() && needle.equals(temp.substring(0, needle.length()))) temp = temp.substring(needle.length());
            if(temp.isEmpty()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem459 problem459 = new Problem459();
        System.out.println(problem459.repeatedSubstringPattern("abab"));
        System.out.println(problem459.repeatedSubstringPattern("aba"));
        System.out.println(problem459.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(problem459.repeatedSubstringPattern("bb"));
        System.out.println(problem459.repeatedSubstringPattern("abac"));
    }
}
