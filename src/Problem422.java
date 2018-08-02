import java.util.ArrayList;
import java.util.List;

public class Problem422 {

    public boolean validWordSquare(List<String> words) {
        int max = Integer.MIN_VALUE;
        for(String word : words) max = Math.max(max, word.length());

        char[][] arr = new char[words.size()][max];

        int row = 0, col;
        for(String word : words) {
            int k = 0;
            col = 0;
            for(; col < max && k < word.length(); col++) arr[row][col] = word.charAt(k++);
            row++;
        }

        row = 0;
        col = 0;
        while (row < words.size() && col < max) {
            StringBuilder sbRow = new StringBuilder();
            StringBuilder sbCol = new StringBuilder();
            for(int k = 0; k < max; k++) sbRow.append(arr[row][k]);
            for(int m = 0; m < words.size(); m++) sbCol.append(arr[m][col]);
            if(!sbRow.toString().equals(sbCol.toString())) return false;
            row++;
            col++;
        }

        return true;
    }

    public static void main(String[] args){
        Problem422 problem422 = new Problem422();
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("b");

        System.out.println(problem422.validWordSquare(list));

    }

}
