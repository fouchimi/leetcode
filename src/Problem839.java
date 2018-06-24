import java.util.ArrayList;
import java.util.List;

public class Problem839 {

    public int numSimilarGroups(String[] A) {
        List<Integer>[] adj = new ArrayList[A.length];

        for(int v = 0; v < adj.length; v++) adj[v] = new ArrayList();

        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                if(areSimilar(A[i], A[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[A.length];
        int groupCount = 0;
        for(int v = 0; v < A.length; v++) {
            if(!visited[v]){
                dfs(v, adj, visited);
                groupCount++;
            }
        }
        return groupCount;
    }

    private boolean areSimilar(String str1, String str2) {
        int mismatch = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                mismatch++;
                if(mismatch > 2) return false;
            }
        }
        return  true;
    }

    private void dfs(int s, List<Integer>[] adj, boolean[] visited) {
        visited[s] = true;
        for (int w : adj[s]) {
            if(!visited[w]) dfs(w, adj, visited);
        }
    }

    public static void main(String[] args) {
        String[] A = {"tars","rats","arts","star"};
        Problem839 problem839 = new Problem839();
        System.out.println(problem839.numSimilarGroups(A));
    }

}
