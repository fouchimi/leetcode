import java.util.*;

public class Problem165 {

    public int compareVersion(String version1, String version2) {

        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        String[] version1Arr = version1.indexOf('.') > 0 ? version1.split("\\.") : new String[]{version1};
        String[] version2Arr = version2.indexOf('.') > 0 ? version2.split("\\.") : new String[]{version2};

        fillQueue(firstQueue, version1Arr);
        fillQueue(secondQueue, version2Arr);

         while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
             Integer first = firstQueue.element();
             Integer second = secondQueue.element();
             if(first > second) return 1;
             else if(first < second) return -1;
             firstQueue.poll();
             secondQueue.poll();
         }

         if(!firstQueue.isEmpty() && !areZeroes(firstQueue)) return 1;
         else if(!secondQueue.isEmpty() && !areZeroes(secondQueue)) return -1;
         return 0;
    }

    private void fillQueue(Queue<Integer> queue, String[] chunks) {
        for(int i = 0; i < chunks.length; i++) queue.add(Integer.parseInt(chunks[i]));
    }

    private boolean areZeroes(Queue<Integer> queue) {
        while (!queue.isEmpty() && queue.element() == 0) queue.poll();
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        Problem165 problem165 = new Problem165();
        System.out.println(problem165.compareVersion("01", "1"));
        System.out.println(problem165.compareVersion("0.1", "1.1"));
        System.out.println(problem165.compareVersion("1.0.1", "1"));
        System.out.println(problem165.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(problem165.compareVersion("1.0", "1"));
        System.out.println(problem165.compareVersion("0010.0", "00010"));
    }
}
