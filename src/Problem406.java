import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (pair1, pair2) -> {
            if(pair1[0] == pair2[0]) {
                return pair1[1] - pair2[1];
            }
            return pair2[0] - pair1[0];
        });

        List<int[]> list = new LinkedList<>();
        for(int[] person : people) list.add(person[1], person);

        int[][] ans = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {
        Problem406 problem406 = new Problem406();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = problem406.reconstructQueue(people);
        for(int[] person : result) System.out.println(person[0] + " " + person[1]);
    }
}
