import java.util.*;

public class Problem350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> firstMap = new LinkedHashMap<>(), secondMap = new LinkedHashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            if(!firstMap.containsKey(nums1[i])) firstMap.put(nums1[i], 1);
            else firstMap.put(nums1[i], firstMap.get(nums1[i])+1);
        }

        for(int j = 0; j < nums2.length; j++) {
            if(!secondMap.containsKey(nums2[j])) secondMap.put(nums2[j], 1);
            else secondMap.put(nums2[j], secondMap.get(nums2[j])+1);
        }

        Iterator itr = firstMap.entrySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) itr.next();
            if(secondMap.containsKey(pair.getKey())) {
                int k = Math.min(firstMap.get(pair.getKey()), secondMap.get(pair.getKey()));
                while (k > 0) {
                    list.add(pair.getKey());
                    k--;
                }
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for(int w : list) result[index++] = w;

        return result;
    }

    public static void main(String[] args) {
        Problem350 problem350 = new Problem350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = problem350.intersect(nums1, nums2);
        for(int val : result) System.out.print(val + " ");
    }
}
