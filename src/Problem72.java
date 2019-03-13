public class Problem72 {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        if(word1.length() == 0) return word2.length();
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

    private int minDistanceUtil(char[] word1, char[] word2, int i, int j, int[][] cache) {
        if(word1.length == i) return word2.length - j;
        if(word2.length == j) return word1.length - i;

        if(cache[i][j] != -1) return cache[i][j];

        if(word1[i] == word2[j]) {
            cache[i][j] = minDistanceUtil(word1, word2, i+1, j+1, cache);
        } else {
            // delete word1[i]
            int delete = minDistanceUtil(word1, word2, i+1, j, cache);

            // insert character word1[i] to match word2[j]
            int insert = minDistanceUtil(word1, word2, i, j+1, cache);

            // replace character word1[i] to match words[j]
            int update = minDistanceUtil(word1, word2, i+1, j+1, cache);

            cache[i][j] = Math.min(Math.min(delete, insert), update)+1;
        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        Problem72 problem72 = new Problem72();
        System.out.println(problem72.minDistance("horse", "ros"));
    }
}
