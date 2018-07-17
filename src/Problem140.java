import java.util.*;

public class Problem140 {

    /*public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        workBreakUtil(s, wordDict, list, resultList);
        return resultList;
    }

    private void workBreakUtil(String s, List<String> wordDict, List<String> list, List<String> resultList) {
        if(s.isEmpty() && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for(String word : list) sb.append(word + " ");
            resultList.add(sb.toString().trim());
        }else {
            for(int i = 1; i <=s.length(); i++) {
                if(wordDict.contains(s.substring(0, i))) {
                    String current = s.substring(0, i);
                    list.add(current);
                    s = s.substring(i);
                    workBreakUtil(s, wordDict, list, resultList);
                    list.remove(list.size()-1);
                    s = current + s;
                }
            }
        }
    }*/

    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>());
    }

    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Problem140 problem140 = new Problem140();
        //String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        /*wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa"); */
        List<String> result = problem140.wordBreak(s, wordDict);
        System.out.println(result);
    }

}
