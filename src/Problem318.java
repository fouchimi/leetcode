import java.util.*;

public class Problem318 {

    public int maxProduct(String[] words){

        List<Integer>[] adj = new ArrayList[words.length];
        for(int v = 0; v < adj.length; v++) adj[v] = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(areCommon(words[i], words[j])) {
                    adj[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[words.length];
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(int v = 0; v < words.length; v++) {
            if(!visited[v]) {
                dfs(v, adj, visited, list, words);
                if (!list.isEmpty()) {
                    map.put(list.get(0), list.get(0));
                    list.remove(list.size()-1);
                }
            }
        }

        Set<String> keys = map.keySet();
        List<String> keyList = new ArrayList<>(keys);
        int max = 0;
        for(int i = 0; i < keyList.size(); i++) {
            for(int j = i+1; j < keyList.size(); j++) {
                max = Math.max(max, keyList.get(i).length() * keyList.get(j).length());
            }
        }
        return max;
    }

    private boolean areCommon(String str1, String str2) {
        for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) return true;
            }
        }

        return false;
    }

    private void dfs(int s, List<Integer>[] adj, boolean[] visited, List<String> list, String[] words) {
        if(visited[s]) return;
        visited[s] = true;
        list.add(words[s]);
        for(int w : adj[s]) {
            if(!visited[w]) dfs(w, adj, visited, list, words);
        }
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Problem318 problem318 = new Problem318();
        System.out.println(problem318.maxProduct(words));
    }
}
