import java.util.*;

public class Problem274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = n; h >= 1; h--) {
            int cntAtLeast = getAtLeast(h, citations);
            int cntNoMoreThan = getNoMoreThan(h, citations);
            if (cntAtLeast >= h && cntNoMoreThan >= n - h) {
                return h;
            }
        }
        return 0;
    }

    private static int getNoMoreThan(int h, int[] citations) {
        int cnt = 0;
        for (int citation : citations) {
            if (citation <= h)
                cnt++;
        }
        return cnt;
    }

    private static int getAtLeast(int h, int[] citations) {
        int cnt = 0;
        for (int citation : citations) {
            if (citation >= h)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem274 problem274 = new Problem274();
        int[] citations = {1, 2};
        System.out.println(problem274.hIndex(citations));
        int[] arr = {3,0,6,1,5};
        System.out.println(problem274.hIndex(arr));
        int[] nums = {8, 3, 5, 4, 10};
        System.out.println(problem274.hIndex(nums));
        int[] vals = {3, 25, 8, 3, 5};
        System.out.println(problem274.hIndex(vals));
    }
}