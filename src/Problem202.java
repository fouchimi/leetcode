import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem202 {

    public boolean isHappy(int n) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> seenList = new ArrayList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int num = queue.poll(), sum = 0;
            if(num == 1) return true;
            if(num < 10) {
                sum = num * num;
                queue.add(sum);
                if(seenList.contains(sum)) return false;
                seenList.add(sum);
            }
            else {
                while (num > 0) {
                    int r = num % 10;
                    num /= 10;
                    sum += r*r;
                }
                queue.add(sum);
                if(seenList.contains(sum)) return false;
                seenList.add(sum);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem202 problem202 = new Problem202();
        System.out.println(problem202.isHappy(19));
    }
}
