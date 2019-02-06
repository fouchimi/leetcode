import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem817 {

    class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        void union(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            if(root_p == root_q) return;
            if(rank[root_p] > rank[root_q]) parent[root_q] = root_p;
            else {
                parent[root_p] = root_q;
                if(rank[root_p] == rank[root_q]) rank[root_q]++;
            }
        }

        int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        int get(int p) {
            return parent[p];
        }
    }

    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : G) map.put(val, val);
        int N = 0;
        ListNode cursor = head;
        while (cursor != null) {
            N++;
            cursor = cursor.next;
        }
        UnionFind uf = new UnionFind(N);
        ListNode curr = head, prev;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            if(curr != null && map.containsKey(curr.val) && map.containsKey(prev.val)) uf.union(curr.val, prev.val);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer key : map.keySet()) set.add(uf.get(key));
        return set.size();
    }

    public static void main(String[] args) {
        Problem817 problem817 = new Problem817();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        int[] G = {0, 3, 1, 4};
        System.out.println(problem817.numComponents(head, G));
    }

}
