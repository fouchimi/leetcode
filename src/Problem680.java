public class Problem680 {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        if(i >= j) return true;
        if(isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1)) return true;
        return false;
    }

    private boolean isPalindrome(String s, int i,  int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    public static void main(String[]  args){
        Problem680 problem680 = new Problem680();
        System.out.println(problem680.validPalindrome("aba"));
        System.out.println(problem680.validPalindrome("abca"));
    }
}
