import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem532 {

    class Tuple {
        int x, y;
        private Tuple (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            else if(!(obj instanceof Tuple)) return false;
            Tuple tuple = (Tuple) obj;
            return (this.x == tuple.x && this.y == tuple.y) || (this.x == tuple.y && this.y == tuple.x);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 *  result * Integer.hashCode(this.x);
            result = 31 *  result * Integer.hashCode(this.y);
            return result;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int N = nums.length;
        Map<Tuple, Tuple> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int val = nums[i], j = i+1, l = i-1;
            int first = val + k, second = val - k;

            while (j < N) {
                if(nums[j] == first && !map.containsKey(new Tuple(val, first))) {
                    Tuple tuple = new Tuple(val, first);
                    map.put(tuple, tuple);
                }

                if(nums[j] == second && !map.containsKey(new Tuple(val, second))) {
                    Tuple tuple = new Tuple(val, second);
                    map.put(tuple, tuple);
                }
                j++;
            }

            while (l >= 0) {
                if((nums[l] == first && !map.containsKey(new Tuple(val, first)))) {
                    Tuple tuple = new Tuple(val, first);
                    map.put(tuple, tuple);
                }

                if(nums[l] == second && !map.containsKey(new Tuple(val, second))) {
                    Tuple tuple = new Tuple(val, second);
                    map.put(tuple, tuple);
                }
                l--;
            }

        }

        for(Map.Entry<Tuple, Tuple> tuple : map.entrySet()) {
            System.out.print(tuple.getKey() + " ");
        }
        System.out.println();

        return map.size();
    }

    public static void main(String[] args) {
        Problem532 problem532 = new Problem532();
        int[] nums = {2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1};
        int k = 1;

        System.out.println(problem532.findPairs(nums, k));
    }
}
