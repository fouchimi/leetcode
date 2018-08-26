import java.util.ArrayList;
import java.util.List;

public class Problem482 {

    public String licenseKeyFormatting(String S, int K) {
        String[] chunks = S.split("-");
        if(chunks.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < chunks.length; i++) {
            for(int j = 0; j < chunks[i].length(); j++) list.add(chunks[i].charAt(j));
        }
        int r = list.size() % K;
        while (r > 0) {
            sb.append(Character.toUpperCase(list.remove(0)));
            r--;
        }
        if(sb.toString().length() > 0) sb.append("-");
        while (!list.isEmpty()){
            int N = K;
            StringBuilder tempSb = new StringBuilder();
            while (N > 0 && !list.isEmpty()) {
                Character ch = list.remove(0);
                tempSb.append(Character.toUpperCase(ch));
                N--;
            }
            tempSb.append("-");
            sb.append(tempSb.toString());
        }
        String str = sb.toString();
        return str.substring(0, str.length()-1);
    }

    public static void main(String[] args){
        Problem482 problem482 = new Problem482();
        String S="5F3Z-2e-9-w";
        System.out.println(problem482.licenseKeyFormatting(S, 4));
    }
}
