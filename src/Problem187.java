import java.util.*;

public class Problem187 {

//    public List<String> findRepeatedDnaSequences(String s) {
//
//        Map<String, Integer> map = new HashMap<>();
//        int i = 0;
//
//        while (i < s.length()) {
//            int j = i+1, end = i+10;
//            if(j < s.length() && end <= s.length()) {
//                String key = s.substring(i, end);
//                if(map.containsKey(key)) {
//                    map.put(key, map.get(key)+1);
//                    i++;
//                    continue;
//                } else map.put(key, 1);
//            }
//
//            while (j < s.length() && j+10 <= s.length()) {
//                String needle = s.substring(j, j+10);
//                if(map.containsKey(needle)) map.put(needle, map.get(needle)+1);
//                j++;
//            }
//            i++;
//        }
//
//        List<String> resultList = new ArrayList<>();
//        Iterator itr = map.entrySet().iterator();
//
//        while (itr.hasNext()) {
//            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) itr.next();
//            if(pair.getValue() > 1) resultList.add(pair.getKey());
//        }
//
//        return resultList;
//    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i+10);
            if(!seen.add(ten)) repeated.add(ten);
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        Problem187 problem187 = new Problem187();
        System.out.println(problem187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(problem187.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
