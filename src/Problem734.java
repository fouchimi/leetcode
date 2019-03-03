public class Problem734 {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs){
        if(words1.length != words2.length) return false;
        for(int i = 0; i < words1.length; i++) {
            String first = words1[i];
            String second = words2[i];

            if(first.equals(second)) continue;
            boolean found = false;

            for(int j = 0; j < pairs.length; j++) {
                String[] currentPair = pairs[j];
                if((currentPair[0].equals(first) && currentPair[1].equals(second)) ||
                        (currentPair[0].equals(second) && currentPair[1].equals(first))) {
                    found = true;
                    break;
                }
            }

            if(!found) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem734 problem734 = new Problem734();
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = {{"great", "fine"}, {"acting","drama"}, {"skills","talent"}};
        System.out.println(problem734.areSentencesSimilar(words1, words2, pairs));
    }
}
