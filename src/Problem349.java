import java.util.*;

public class Problem349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> firstMap = new LinkedHashMap<>(), secondMap = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) firstMap.put(nums1[i], nums1[i]);
        for(int j = 0; j < nums2.length; j++) secondMap.put(nums2[j], nums2[j]);

        Iterator itr = firstMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) itr.next();
            if(secondMap.containsKey(pair.getKey())) list.add(pair.getKey());
        }

        int[] result = new int[list.size()];
        int k = 0;
        for(int w : list)
            result[k++] = w;
        return result;
    }

    public static void main(String[] args) {
        Problem349 problem349 = new Problem349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = problem349.intersection(nums1, nums2);
        for(int val : result) System.out.print(val + " ");
    }
}
