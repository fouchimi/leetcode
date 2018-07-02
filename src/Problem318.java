import java.util.*;

public class Problem318 {

    public int maxProduct(String[] words){
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(!hasSameChar(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public boolean hasSameChar(String s1, String s2){
        for(int k=0; k<s2.length(); k++){
            if(s1.contains(String.valueOf(s2.charAt(k)))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Problem318 problem318 = new Problem318();
        System.out.println(problem318.maxProduct(words));
    }
}
