public class Problem6 {

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows == 1) return s;
        int step1, step2, len = s.length();
        for(int i = 0; i < numRows; i++) {
            step1 = 2*(numRows-i-1);
            step2 = 2*i;
            int pos = i;
            if(pos < len) {
                sb.append(s.charAt(pos));
            }
            while (true) {
                pos += step1;
                if(pos >= len) break;
                if(step1 > 0) sb.append(s.charAt(pos));
                pos += step2;
                if(pos >= len) break;
                if(step2 > 0) sb.append(s.charAt(pos));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.convert("PAYPALISHIRING", 3));
    }
}
