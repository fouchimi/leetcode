public class Problem583 {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length() == 0) return  word2.length();
        if(word2.length() == 0) return word1.length();

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int[][] cache = new int[c1.length][c2.length];

        for(int i = 0; i < c1.length; i++) {
            for(int j = 0; j < c2.length; j++) {
                cache[i][j] = -1;
            }
        }

        return minDistanceUtil(c1, c2, 0, 0, cache);
    }

    public int minDistanceUtil(char[] word1, char[] word2, int i, int j, int[][] cache) {
        if(word1.length == i) return word2.length - j;
        if(word2.length == j) return word1.length - i;

        if(cache[i][j] > 0) return cache[i][j];

        int min;
        if(word1[i] == word2[j]) {
            min = minDistanceUtil(word1, word2, i+1, j+1, cache);
        }else {
            int deleteWord1Count = minDistanceUtil(word1, word2, i+1, j, cache) + 1;
            int deleteWord2Count = minDistanceUtil(word1, word2, i, j+1, cache) + 1;
            min = Math.min(deleteWord1Count, deleteWord2Count);
        }
        cache[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        Problem583 problem583 = new Problem583();
        System.out.println(problem583.minDistance("sea", "eat"));
    }
}
