import java.util.*;

public class Problem322 {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 1) return 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.addFirst(amount);
        visited.add(amount);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.removeLast();
                if(curr == 0) return level;
                if(curr < 0) continue;
                for(int coin : coins) {
                    int next = curr - coin;
                    if(next >= 0 && !visited.contains(next)) {
                        queue.addFirst(next);
                        visited.add(next);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem322 problem322 = new Problem322();
        int[] coins = new int[]{1, 2, 5, 8};
        System.out.println(problem322.coinChange(coins,  11));
    }
}
