public class Problem161 {

    public boolean isOneEditDistance(String s, String t) {
        if((s.length() == 1 && t.isEmpty()) || (t.length() == 1 && s.isEmpty())) return true;
        else {
            int i = 0, j = 0, diff = 0;
            String max, min;
            if(s.length() > t.length()) {
                max = s;
                min = t;
            }else {
                max = t;
                min = s;
            }
            while (i < max.length() && j < min.length()) {
                if(max.charAt(i) == min.charAt(j)) {
                    i++;
                    j++;
                }else if(max.length() > min.length() && max.charAt(i) != min.charAt(j)) {
                    diff++;
                    i++;
                }else if(max.length() == min.length() && max.charAt(i) != min.charAt(j)) {
                    i++;
                    j++;
                    diff++;
                }
                if(diff > 1) return false;
            }

            while (i < max.length()) {
                diff++;
                if(diff > 1) return false;
                i++;
            }

            return diff == 1;
        }
    }

    public static void main(String[] args) {
        Problem161 problem161 = new Problem161();
        System.out.println(problem161.isOneEditDistance("ab", "acb"));
        System.out.println(problem161.isOneEditDistance("cab", "ad"));
        System.out.println(problem161.isOneEditDistance("1203", "1213"));
        System.out.println(problem161.isOneEditDistance("a", "ac"));
        System.out.println(problem161.isOneEditDistance("", "ab"));
        System.out.println(problem161.isOneEditDistance("dc", ""));
    }
}
