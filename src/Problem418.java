public class Problem418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        int k = 0, counter = 0;
        while (rows > 0) {
            int N = cols;
            while (N > 0) {
                String next = sentence[k];
                N = N-next.length() -1;
                if((k+1 < sentence.length && N >= sentence[k+1].length()) || (k+1 == sentence.length && N > 0)) k++;
                else if(k+1 < sentence.length && N < sentence[k+1].length()) break;
                if(k == sentence.length) counter++;
                k %= sentence.length;
            }
            if(k >= sentence.length) {
                k = 0;
                counter++;
            }else k++;
            rows--;
        }
        return counter;
    }

    public static void main(String[] args) {
        Problem418 problem418 = new Problem418();
        String[] sentence = {"a", "bcd", "e"};
        System.out.println(problem418.wordsTyping(sentence, 3, 6));
    }
}
