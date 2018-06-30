import java.util.*;

public class Problem299 {
    public String getHint(String secret, String guess) {
        StringBuilder firstSb = new StringBuilder(), secondSb = new StringBuilder();
        int bull = 0;
        Map<Character, Integer> firstMap = new HashMap<>(), secondMap = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }else {
                firstSb.append(secret.charAt(i));
                secondSb.append(guess.charAt(i));
            }
        }

        secret = firstSb.toString();
        guess = secondSb.toString();
        for(int j = 0; j < secret.length(); j++) {
            if(firstMap.containsKey(secret.charAt(j))) firstMap.put(secret.charAt(j), firstMap.get(secret.charAt(j)) + 1);
            else firstMap.put(secret.charAt(j), 1);
        }

        for(int k = 0; k < guess.length(); k++) {
            if(secondMap.containsKey(guess.charAt(k))) secondMap.put(guess.charAt(k), secondMap.get(guess.charAt(k)) + 1);
            else secondMap.put(guess.charAt(k), 1);
        }

        int cow = 0;
        Iterator itr = secondMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            if(firstMap.containsKey(pair.getKey())) cow += Math.min(firstMap.get(pair.getKey()), secondMap.get(pair.getKey()));
        }


        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        Problem299 problem299 = new Problem299();
        String secret = "1807", guess = "7810";
        System.out.println(problem299.getHint(secret, guess));
    }
}
