import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem247 {

    public List<String> findStrobogrammatic(int n) {

        return helper(n, n);
    }

    private List<String> helper(int m, int n) {
        if(m == 0) {
            List<String> res = Arrays.asList("");
            return res;
        }
        if(m == 1) {
            List<String> res = Arrays.asList("0", "1", "8");
            return res;
        }

        List<String> list = helper(m-2, n);
        List<String> res = new ArrayList<>();
        for(String s : list) {
            if(n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9" );
            res.add("8" + s + "8" );
            res.add("9" + s + "6" );
        }
        return res;
    }

    public static void main(String[] args) {
        Problem247 problem247 = new Problem247();
        System.out.println(problem247.findStrobogrammatic(4));
    }
}
