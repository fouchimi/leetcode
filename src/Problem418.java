public class Problem418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int k = 0, counter = 0;
        while (rows > 0) {
            int N = cols;
            while (N > 0) {
                String next = sentence[k];
                if(N == next.length()) N = N-next.length();
                else if(N > next.length()) N = N-next.length()-1;
                else break;
                if(k == sentence.length-1) counter++;
                k++;
                k %= sentence.length;
            }
            rows--;
        }
        return counter;
    }

    public static void main(String[] args) {
        Problem418 problem418 = new Problem418();
        String[] sentence = {"Hello", "World"};
        System.out.println(problem418.wordsTyping(sentence, 2, 8));
        String[] sentence1 = {"a", "bcd", "e"};
        System.out.println(problem418.wordsTyping(sentence1, 3, 6));
        String[] sentence2 = {"I", "had", "apple", "pie"};
        System.out.println(problem418.wordsTyping(sentence2, 4, 5));
    }
}
