public class Problem557 {

    public String reverseWords(String s) {

        if(s == null || s.length() == 0) return s;

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(reverse(str) + " ");
        }
        return sb.toString().trim();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int j = s.length()-1; j >= 0; j--) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem557 problem557 = new Problem557();
        System.out.println(problem557.reverseWords("Let's take LeetCode contest"));
    }

}
