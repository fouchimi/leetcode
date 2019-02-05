public class Problem418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int k = 0, count = 0;
        while (rows > 0) {
            int N = cols;
            while (N > 0) {
                String next = sentence[k];
                int length = next.length();
                if(N < length) break;
                else  if(N == length) {
                    N = N-length;
                }
                else N = N-length-1;
                if(k == sentence.length-1) count++;
                k++;
                k %= sentence.length;
            }
            rows--;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem418 problem418 = new Problem418();
        String[] sentence = {"Hello", "World"};
        System.out.println(problem418.wordsTyping(sentence, 2, 8));
        String[] sentence1 = {"a", "bcd", "e"};
        System.out.println(problem418.wordsTyping(sentence1, 3, 6));
        String[] sentence2 = {"I", "had", "apple", "pie"};
        System.out.println(problem418.wordsTyping(sentence2, 4, 5));
        String[] sentence3 = {"a"};
        System.out.println(problem418.wordsTyping(sentence3, 20000, 20000));
        String[] sentence4 = {"h"};
        System.out.println(problem418.wordsTyping(sentence4, 2, 3));
        String[] sentence5 = {"p"};
        System.out.println(problem418.wordsTyping(sentence5, 100, 100));
        String[] sentence6 = {"f", "p", "a"};
        System.out.println(problem418.wordsTyping(sentence6, 8, 7));
    }
}
