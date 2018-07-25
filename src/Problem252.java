import java.util.Arrays;
import java.util.Comparator;

public class Problem252 {

    public static class Interval {
        int start, end;
        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval first, Interval second) {
                if(first.start < second.start || (first.start == second.start && first.end < second.end)) return -1;
                else if(first.start == second.start && first.end == second.end) return 0;
                return 1;
            }
        });

        for(Interval interval : intervals) System.out.print(interval + " ");

        Interval prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(prev.end > intervals[i].start) return false;
            prev = intervals[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Problem252 problem252 = new Problem252();
        Interval[] intervals = { new Interval(5, 10), new Interval(0, 30), new Interval(15, 20)};
        System.out.println(problem252.canAttendMeetings(intervals));
        Interval[] intervals2 = {new Interval(7, 10), new Interval(2, 4)};
        System.out.println(problem252.canAttendMeetings(intervals2));
    }
}