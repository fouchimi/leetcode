public class Problem551 {

    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) return false;
        int count = 0;
        for(int i = 0; i < s.length(); ) {
            int start = i;
            if(s.charAt(i) == 'A') {
                count++;
                if(count == 2) return false;
                while (i < s.length() && s.charAt(i) == 'A') i++;
                if(i - start > 1) return false;
            } else if(s.charAt(i) == 'L') {
                while (i < s.length() && s.charAt(i) == 'L') i++;
                if(i - start > 2) return false;
            }
            else i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem551 problem551 = new Problem551();
        System.out.println(problem551.checkRecord("PPALLP"));
        System.out.println(problem551.checkRecord("PPALLL"));
    }
}
