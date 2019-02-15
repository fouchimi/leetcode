import java.util.ArrayList;
import java.util.List;

public class Problem984 {

    public String strWithout3a3b(int A, int B) {
        List<String> list = new ArrayList();
        helper("", A, B, list);
        return list.get(0);
    }

    private void helper(String res, int A, int B, List<String> list) {
        if(!list.isEmpty()) return;
        else if(A == 0 && B == 0) list.add(res);
        else {
            String lastStr = "";
            if(res.length() >= 2) lastStr = res.substring(res.length()-2);
            if(A >= 0 && B >= 0) {
                if(A > B) {
                    if(!lastStr.equals("aa")) {
                        helper(res + "a", A-1, B, list);
                        if(A > 1) helper(res + "aa", A-2, B, list);
                    }
                    if(B > 0 && !lastStr.equals("bb")) {
                        helper(res + "b", A, B-1, list);
                        if(B > 1) helper(res + "bb", A, B-2, list);
                    }
                } else {
                    if(!lastStr.equals("bb")) {
                        helper(res + "b", A, B-1, list);
                        if(B > 1) helper(res + "bb", A, B-2, list);
                    }
                    if(A > 0 && !lastStr.equals("aa")) {
                        helper(res + "a", A-1, B, list);
                        if(A > 1) helper(res + "aa", A-2, B, list);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem984 problem984 = new Problem984();
        System.out.println(problem984.strWithout3a3b(1, 3));
    }
}
