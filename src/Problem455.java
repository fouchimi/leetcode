import java.util.Arrays;

public class Problem455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(g[i]<=s[j]) i++;
        }
        return i;
    }


    public static void main(String[] args){
        Problem455 problem455 = new Problem455();
        int[] s = {1, 2, 3};
        int[] g = {1, 1};
        System.out.println(problem455.findContentChildren(g, s));
    }

}
