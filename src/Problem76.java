public class Problem76 {

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for(char ch : t.toCharArray()) {
            cnt[ch]++;
        }
        int from = 0, total = t.length(), min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if(i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if(++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    public static void main(String[] args) {
        Problem76 problem76 = new Problem76();
        System.out.println(problem76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
