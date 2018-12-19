public class Problem408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < abbr.length() && j < word.length()) {
            int k = i;
            if (Character.isDigit(abbr.charAt(k)) && abbr.charAt(k) != '0') {
                int startIndex = k;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k))) ++k;
                int endIndex = Integer.parseInt(abbr.substring(startIndex, k));
                if (j + endIndex <= word.length()){
                    i = k;
                    j += endIndex;
                }
                else return false;
            } else if (abbr.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else return false;
        }
        return i == abbr.length() && j == word.length();
    }

    public static void main(String[] args) {
        Problem408 problem408 = new Problem408();
        System.out.println(problem408.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(problem408.validWordAbbreviation("apple", "a2e"));
        System.out.println(problem408.validWordAbbreviation("hi", "2i"));
    }
}
