import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Problem423 {

    public String originalDigits(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        char[] strs = s.toCharArray();
        ArrayList[] map = new ArrayList[10];
        for(int i = 0; i < map.length; i++) map[i] = new ArrayList<>();
        for(int i  = 0; i < strs.length; i++) queue.add(strs[i]);
        while (!queue.isEmpty()) {
            if(queue.contains('z')) {
                removeFromQueue(queue, "zero");
                map[0].add(0);
            } else if(queue.contains('w')) {
                removeFromQueue(queue, "two");
                map[2].add(2);
            } else if(queue.contains('u')) {
                removeFromQueue(queue, "four");
                map[4].add(4);
            } else if(queue.contains('x')) {
                removeFromQueue(queue, "six");
                map[6].add(6);
            } else if(queue.contains('g')) {
                removeFromQueue(queue, "eight");
                map[8].add(8);
            } else if(isAvailable(queue, "one")){
                removeFromQueue(queue, "one");
                map[1].add(1);
            } else if(isAvailable(queue, "three")) {
                removeFromQueue(queue, "three");
                map[3].add(3);
            } else if(isAvailable(queue, "five")) {
                removeFromQueue(queue, "five");
                map[5].add(5);
            } else if(isAvailable(queue, "seven")) {
                removeFromQueue(queue, "seven");
                map[7].add(7);
            } else {
                removeFromQueue(queue, "nine");
                map[9].add(9);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            if(!map[i].isEmpty()) {
                ArrayList<Integer> currentList = map[i];
                for(Integer digit : currentList) sb.append(digit);
            }
        }

        return sb.toString();
    }

    private void removeFromQueue(Queue<Character> queue, String str) {
        for(int i = 0; i < str.length(); i++) queue.remove(str.charAt(i));
    }

    private boolean isAvailable(Queue<Character> queue, String str) {
        for(int i = 0; i < str.length(); i++) {
            if(!queue.contains(str.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem423 problem423 = new Problem423();
        System.out.println(problem423.originalDigits("owoztneoer"));
        System.out.println(problem423.originalDigits("fviefuro"));
        System.out.println(problem423.originalDigits("zerozero"));
        System.out.println(problem423.originalDigits("nnei"));
    }
}
