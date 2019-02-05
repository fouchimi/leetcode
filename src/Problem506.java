import java.util.HashMap;
import java.util.Map;

public class Problem506 {


    public String[] findRelativeRanks(int[] nums) {
        int N = nums.length, k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            map.put(nums[i], i);
            if(nums[i] > max) max = nums[i];
        }
        int[] tempArr = new int[max + 1];
        for(int i = 0; i < N; i++) tempArr[nums[i]] = nums[i];
        String[] res = new String[N];
        for(int j = tempArr.length-1; j >= 0; j--) {
            int key = tempArr[j];
            if(map.containsKey(key)) {
                if(key == 0) res[map.get(key)] = String.valueOf(N);
                else if(k == 0) res[map.get(key)] = "Gold Medal";
                else if(k == 1) res[map.get(key)] = "Silver Medal";
                else if(k == 2) res[map.get(key)] = "Bronze Medal";
                else res[map.get(key)] = String.valueOf(k+1);
                if(key > 0) k++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Problem506 problem506 = new Problem506();
        int[] nums = {123123,11921,1,0,123};
        String[] res = problem506.findRelativeRanks(nums);
        for(String word : res) System.out.print(word + " ");
        System.out.println();
    }

}
