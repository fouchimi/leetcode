import java.util.HashMap;
import java.util.Map;

public class Problem888 {

    public int[] fairCandySwap(int[] A, int[] B) {

        int[] ans = new int[2];
        int sumA = 0, sumB = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) sumA += A[i];

        for(int j = 0; j < B.length; j++) {
            sumB += B[j];
            map.put(B[j], map.getOrDefault(B[j], 0)+1);
        }

        int avg = (sumA + sumB) /  2;

        for(int i = 0; i < A.length; i++) {
            int next = A[i] + sumB - avg;
            if(map.containsKey(next)) {
                ans[0] = A[i];
                ans[1] = next;
                break;
            }
        }

        return ans;
    }

    private void print(int[] res) {
        for(int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem888 problem888 = new Problem888();
        int[] A = {1, 1};
        int[] B = {2, 2};
        int[] ans = problem888.fairCandySwap(A, B);
        problem888.print(ans);
        int[] C = {1, 2};
        int[] D = {2, 3};
        ans = problem888.fairCandySwap(C, D);
        problem888.print(ans);
        int[] E = {2};
        int[] F = {1, 3};
        ans = problem888.fairCandySwap(E, F);
        problem888.print(ans);
        int[] G = {1, 2, 5};
        int[] H = {2, 4};
        ans = problem888.fairCandySwap(G, H);
        problem888.print(ans);
    }

}
