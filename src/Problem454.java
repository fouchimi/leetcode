import java.util.HashMap;
import java.util.Map;

public class Problem454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                int sum = A[i] + B[j];
                res += map.getOrDefault(-sum, 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Problem454 problem454 = new Problem454();
        /* int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};*/
        int[] A = {0, 1,-1};
        int[] B = {-1,1, 0};
        int[] C = {0, 0, 1};
        int[] D = {-1,1, 1};
        System.out.println(problem454.fourSumCount(A, B, C, D));
    }
}
