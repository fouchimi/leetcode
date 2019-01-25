import java.util.ArrayList;
import java.util.List;

public class Problem134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int N = gas.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(gas[i] >= cost[i]) list.add(i);
        }

        for(int index : list) {
            int next = (index + 1) % N;
            int start = index;
            int sum = gas[index] - cost[index] + gas[next];
            while (sum >= cost[next]) {
                index = (index + 1) % N;
                next = (index + 1) % N;
                if(index == start) return index;
                sum = sum - cost[index] + gas[next];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem134 problem134 = new Problem134();
        System.out.println(problem134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(problem134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
