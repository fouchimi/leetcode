import java.util.HashMap;
import java.util.Map;

public class Problem359 {

    private Map<String, Integer> map;

    Problem359() {
        map = new HashMap<>();
    }


    public boolean shouldPrintMessage(int timestamp, String message) {

        if(map.containsKey(message)) {
            int diff = timestamp - map.get(message);
            if(diff >= 10) map.put(message, timestamp);
            return diff >= 10;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }

    public static void main(String[] args) {
        Problem359 problem359 = new Problem359();
        System.out.println(problem359.shouldPrintMessage(1, "foo"));
        System.out.println(problem359.shouldPrintMessage(2, "bar"));
        System.out.println(problem359.shouldPrintMessage(3, "foo"));
        System.out.println(problem359.shouldPrintMessage(8, "bar"));
        System.out.println(problem359.shouldPrintMessage(10, "foo"));
        System.out.println(problem359.shouldPrintMessage(11, "foo"));
    }

}
