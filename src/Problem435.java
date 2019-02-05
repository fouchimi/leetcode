import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        int overlap = 0;
        if(intervals == null || intervals.length == 0) return overlap;
        Arrays.sort(intervals, Comparator.comparingInt(firstInterval -> firstInterval.start));
        Interval  prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            Interval current = intervals[i];
            if(current.start < prev.end) {
                overlap++;
                if(current.end < prev.end) prev = current;
            } else prev = current;
        }
        return overlap;
    }

    public static void main(String[] args) {
        Problem435 problem435 = new Problem435();
        Interval[] intervals = {new Interval(-100,-87),new Interval(-99,-44),new Interval(-98,-19), new Interval(-97,-33),
                new Interval(-96,-60), new Interval(-95,-17), new Interval(-94,-44), new Interval(-93,-9),  new Interval(-92,-63),
                new Interval(-91,-76), new Interval(-90,-44), new Interval(-89,-18), new Interval(-88,10),  new Interval(-87,-39),
                new Interval(-86,7),   new Interval(-85,-76), new Interval(-84,-51), new Interval(-83,-48), new Interval(-82,-36),
                new Interval(-81,-63), new Interval(-80,-71), new Interval(-79,-4),  new Interval(-78,-63), new Interval(-77,-14),
                new Interval(-76,-10), new Interval(-75,-36), new Interval(-74,31),  new Interval(-73,11),  new Interval(-72,-50),
                new Interval(-71,-30), new Interval(-70,33),  new Interval(-69,-37), new Interval(-68,-50), new Interval(-67,6),
                new Interval(-66,-50), new Interval(-65,-26), new Interval(-64,21),  new Interval(-63,-8),  new Interval(-62,23),
                new Interval(-61,-34), new Interval(-60,13),  new Interval(-59,19),  new Interval(-58,41),  new Interval(-57,-15),
                new Interval(-56,35),  new Interval(-55,-4),  new Interval(-54,-20), new Interval(-53,44),  new Interval(-52,48),
                new Interval(-51,12),  new Interval(-50,-43), new Interval(-49,10),  new Interval(-48,-34), new Interval(-47,3),
                new Interval(-46,28),  new Interval(-45,51),  new Interval(-44,-14), new Interval(-43,59),  new Interval(-42,-6),
                new Interval(-41,-32), new Interval(-40,-12), new Interval(-39,33),  new Interval(-38,17),  new Interval(-37,-7),
                new Interval(-36,-29), new Interval(-35,24),  new Interval(-34,49),  new Interval(-33,-19), new Interval(-32,2),
                new Interval(-31,8), new Interval(-30,74), new Interval(-29,58),
//        [-28,13],[-27,-8],[-26,45],[-25,-5],[-24,45],[-23,19],[-22,9],[-21,54],[-20,1],[-19,81],[-18,17],[-17,-10],[-16,7],[-15,86],
//        [-14,-3],[-13,-3],[-12,45],[-11,93],[-10,84],[-9,20],[-8,3],[-7,81],[-6,52],[-5,67],[-4,18],[-3,40],[-2,42],[-1,49],[0,7],
//        [1,104],[2,79],[3,37],[4,47],[5,69],[6,89],[7,110],[8,108],[9,19],[10,25],[11,48],[12,63],[13,94],[14,55],[15,119],[16,64],
//        [17,122],[18,92],[19,37],[20,86],[21,84],[22,122],[23,37],[24,125],[25,99],[26,45],[27,63],[28,40],[29,97],[30,78],[31,102],
//        [32,120],[33,91],[34,107],[35,62],[36,137],[37,55],[38,115],[39,46],[40,136],[41,78],[42,86],[43,106],[44,66],[45,141],[46,92],
//        [47,132],[48,89],[49,61],[50,128],[51,155],[52,153],[53,78],[54,114],[55,84],[56,151],[57,123],[58,69],[59,91],[60,89],[61,73],
//        [62,81],[63,139],[64,108],[65,165],[66,92],[67,117],[68,140],[69,109],[70,102],[71,171],[72,141],[73,117],[74,124],[75,171],
//        [76,132],[77,142],[78,107],[79,132],[80,171],[81,104],[82,160],[83,128],[84,137],[85,176],[86,188],[87,178],[88,117],[89,115],
//        [90,140],[91,165],[92,133],[93,114],[94,125],[95,135],[96,144],[97,114],[98,183],[99,157]
        };
        System.out.println(problem435.eraseOverlapIntervals(intervals));
    }
}
