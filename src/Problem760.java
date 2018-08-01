import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem760 {


    public int[] anagramMappings(int[] A, int[] B) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        for(int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i])) {
                list = map.get(B[i]);
                list.add(i);
                map.put(B[i], list);
            }else {
                list = new ArrayList<>();
                list.add(i);
                map.put(B[i], list);
            }
        }

        int[] result = new int[A.length];
        int k = 0;
        for(int j = 0; j < A.length; j++) {
            if(map.containsKey(A[j])) {
                list = map.get(A[j]);
                if(!list.isEmpty()) {
                    int val = list.remove(0);
                    map.put(A[j], list);
                    result[k++] = val;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem760 problem760 = new Problem760();
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] R = problem760.anagramMappings(A, B);
        for(int w : R) System.out.print(w + " ");
    }

}
