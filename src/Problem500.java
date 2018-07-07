
import java.util.ArrayList;
import java.util.List;

public class Problem500 {

    public String[] findWords(String[] words) {

        String firstRow = "qQwWeErRtTyYuUiIoOpP";
        String secondRow = "aAsSdDfFgGhHjJkKlL";
        String thirdRow  = "zZxXcCvVbBnNmM";
        char[] firstRowChars = firstRow.toCharArray();
        char[] secondRowChars = secondRow.toCharArray();
        char[] thirdRowChars = thirdRow.toCharArray();

        List<String> list = new ArrayList<>();
        for(String word: words) {
            if(contains(word, firstRowChars)) list.add(word);
            else if(contains(word, secondRowChars)) list.add(word);
            else if(contains(word, thirdRowChars)) list.add(word);
        }

        String[] result = new String[list.size()];
        int i = 0;
        for(String str : list) result[i++] = str;

        return result;
    }

    private boolean contains(String str, char[] chars) {
        int length = 0;
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < chars.length; j++) {
                if(str.charAt(i) == chars[j])  {
                    length++;
                    break;
                }
            }
        }
        return length == str.length();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        Problem500 problem500 = new Problem500();
        String[] result = problem500.findWords(words);
        for(String word : result) System.out.print(word + " ");
    }
}
