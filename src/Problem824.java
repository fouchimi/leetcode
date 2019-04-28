public class Problem824 {

    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) return null;
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(String word : words) {
            if(!isVowel(word.charAt(0))) word = word.substring(1) + word.substring(0, 1);
            result.append(word);
            result.append("ma");
            sb.append('a');
            result.append(sb.toString());
            result.append(' ');
        }
        return result.toString().trim();
    }

    private boolean isVowel(char ch) {
        ch = String.valueOf(ch).toLowerCase().charAt(0);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Problem824 problem824 = new Problem824();
        System.out.println(problem824.toGoatLatin("I speak Goat Latin"));
    }
}
