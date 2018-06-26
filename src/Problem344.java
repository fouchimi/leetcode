public class Problem344 {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) sb.insert(0, s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem344 problem344 = new Problem344();
        System.out.println(problem344.reverseString("hello"));
    }
}
