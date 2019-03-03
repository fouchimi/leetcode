import java.util.ArrayList;
import java.util.List;

public class Problem722 {

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        boolean blockfound = false;
        for(String line : source) {
            for(int i = 0; i < line.length(); i++) {
                if(!blockfound) {
                    if((str.length() > 0) && line.charAt(i) == '/' && str.charAt(str.length()-1) == '/') {
                        str = new StringBuilder(str.substring(0, str.length() - 1));
                        break;
                    } else if((str.length() > 0) && line.charAt(i) == '*' && str.charAt(str.length()-1) == '/') {
                        str = new StringBuilder(str.substring(0, str.length() - 1));
                        blockfound = true;
                        i++;
                    } else str.append(line.charAt(i));
                } else {
                    if(i > 0 && line.charAt(i) =='/' && line.charAt(i-1) == '*') blockfound = false;
                }
            }
            if((str.length() > 0) && !blockfound) {
                res.add(str.toString());
                blockfound = false;
                str = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem722 problem722 = new Problem722();
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "  multiline, ", "  comment for ", "  testing */", "a = b + c;", "}"};
        //String[] source = {"a/*comment", "line", "more_comment*/b"};
        //String[] source = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        List<String> res = problem722.removeComments(source);
        System.out.println(res);
    }
}
