import java.util.Arrays;

public class Problem253 {

    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int nbrRooms = 0, index = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(starts[i] < ends[index]) nbrRooms++;
            else index++;
        }
        return nbrRooms;
    }

    public static void main(String[] args) {
        Problem253 problem253 = new Problem253();

        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(problem253.minMeetingRooms(intervals));

        Interval[] intervals1 = {new Interval(7, 10), new Interval(2, 4)};
        System.out.println(problem253.minMeetingRooms(intervals1));

        Interval[] intervals2 = {new Interval(9, 10), new Interval(4, 9), new Interval(4, 17)};
        System.out.println(problem253.minMeetingRooms(intervals2));

        Interval[] intervals3 = {new Interval(5, 8), new Interval(6, 8)};
        System.out.println(problem253.minMeetingRooms(intervals3));

        Interval[] intervals4 = {new Interval(1, 8), new Interval(4, 6)};
        System.out.println(problem253.minMeetingRooms(intervals4));
    }
}
