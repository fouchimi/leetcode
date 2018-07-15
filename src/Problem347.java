import java.util.*;

public class Problem347 {

    int[] pq;
    int  N = 0;
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i= 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }

        pq = new int[map.size() + 1];
        int index = 1;
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) itr.next();
            pq[index++] = entry.getKey();
            N++;
            swim(map, N);
        }

        List<Integer> list = new ArrayList<>();
        while (k > 0 && N > 0) {
            list.add(pq[1]);
            pq[1] = pq[N--];
            pq[N+1] = Integer.MIN_VALUE;
            sink(map, 1);
            k--;
        }

        return list;
    }

    private void sink(Map<Integer, Integer> map, int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(map, j, j+1)) j++;
            if(less(map, j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private void swim(Map<Integer, Integer> map, int k) {
        while (k > 1 && less(map, k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private boolean less(Map<Integer, Integer> map, int p, int q) {
        return map.get(pq[p]) < map.get(pq[q]);
    }

    private void exch(int p, int q) {
        int temp = pq[q];
        pq[q] = pq[p];
        pq[p] = temp;
    }

    public static void main(String[] args) {
        Problem347 problem347 = new Problem347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(problem347.topKFrequent(nums, 2));
    }
}
