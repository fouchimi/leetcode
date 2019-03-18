public class Problem917 {

    public String reverseOnlyLetters(String S) {
        if(S == null) return null;
        if(S.length() == 0) return S;
        char[] characters = S.toCharArray();
        for(int i = 0, j = characters.length-1; i < j; ){
            if(Character.isLetter(characters[i]) && Character.isLetter(characters[j])) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                i++;
                j--;
            } else if(!Character.isLetter(characters[i]) && Character.isLetter(characters[j])) i++;
            else if(Character.isLetter(characters[i]) && !Character.isLetter(characters[j])) j--;
            else {
                i++;
                j--;
            }
        }
        return String.valueOf(characters);
    }

    public static void main(String[] args) {
        Problem917 problem917 = new Problem917();
        System.out.println(problem917.reverseOnlyLetters("ab-cd"));
        System.out.println(problem917.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
