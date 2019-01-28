import java.util.ArrayList;
import java.util.List;

public class Problem729 {

    class Interval {
        int start, end;
        public Interval (int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    List<Interval> list;

    public Problem729() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(list.isEmpty()) {
            Interval newInterval = new Interval(start, end);
            list.add(newInterval);
        } else {
            int i = 0;
            for(; i < list.size(); i++) {
                Interval current = list.get(i);
                if((start >= current.start && start < current.end) || (start < current.start && end > current.start)) return false;
                else if(start < current.start && end <= current.start) {
                    list.add(i, new Interval(start, end));
                    return true;
                }
            }
            list.add(i, new Interval(start, end));
        }
        return true;
    }

    public static void main(String[] args) {
        Problem729 problem729 = new Problem729();
        System.out.println(problem729.book(47, 50));
        System.out.println(problem729.book(33, 41));
        System.out.println(problem729.book(39, 45));
        System.out.println(problem729.book(33, 42));
        System.out.println(problem729.book(25, 32));
        System.out.println(problem729.book(26, 35));
        System.out.println(problem729.book(19, 25));
        System.out.println(problem729.book(3, 8));
        System.out.println(problem729.book(8, 13));
        System.out.println(problem729.book(18, 27));

//        System.out.println(problem729.book(37, 50));
//        System.out.println(problem729.book(33, 50));
//        System.out.println(problem729.book(4, 17));
//        System.out.println(problem729.book(35, 48));
//        System.out.println(problem729.book(8, 25));

//        System.out.println(problem729.book(10, 20));
//        System.out.println(problem729.book(15, 25));
//        System.out.println(problem729.book(20, 30));
    }
}
