import java.util.ArrayList;
import java.util.List;

public class Problem293 {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> stateList = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != '+') i++;
            if(i+1 < s.length() && s.charAt(i+1) == '+') {
                String currentState = s.substring(0, i) + "--" + s.substring(i+2, s.length());
                stateList.add(currentState);
            }
            i++;
        }
        return stateList;
    }

    public static void main(String[] args) {
        Problem293 problem293 = new Problem293();
        System.out.println(problem293.generatePossibleNextMoves("-"));
    }
}
