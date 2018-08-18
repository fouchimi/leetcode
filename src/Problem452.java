import java.util.ArrayList;
import java.util.List;

public class Problem452 {

    class Interval {
        int x, y;
        Interval(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + this.x + "," + this.y + "]";
        }
    }

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return 0;
        else if(points.length == 1) return 1;
        List<Interval> list = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            Interval currentInterval = new Interval(points[i][0], points[i][1]);
            list.add(currentInterval);
        }

        list.sort((first, second) -> {
            if((first.x == second.x && first.y < second.y) || first.x < second.x) return -1;
            else if(first.x > second.x) return 1;
            return 0;
        });

        for(Interval interval : list) System.out.print(interval + " ");
        System.out.println();

        Interval firstInterval = list.remove(0);
        List<Interval> res = new ArrayList<>();
        while (!list.isEmpty()) {
            Interval nextInterval = list.remove(0);
            if(firstInterval.y > nextInterval.x && firstInterval.y <= nextInterval.y) {
                if(firstInterval.x < nextInterval.x) firstInterval.x = nextInterval.x;
            }else if(firstInterval.y == nextInterval.x && firstInterval.y <= nextInterval.y){
                firstInterval.x = nextInterval.x;
            }else if(firstInterval.y > nextInterval.x) {
                firstInterval.x = nextInterval.x;
                firstInterval.y = nextInterval.y;
            }else {
                res.add(firstInterval);
                firstInterval = nextInterval;
            }
        }

        if(res.isEmpty()) res.add(firstInterval);
        else if(res.get(res.size()-1).y < firstInterval.x) res.add(firstInterval);


        return res.size();
    }

    public static void main(String[] args) {
        Problem452 problem452 = new Problem452();
        //int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int[][] points = {
                {36140795,99621365},
                {40651434,116611812},
                {17097467,109164068},
                {76710097,104322999},
                {30573317,34143809},
                {87926652,148187408},
                {59997301,145557581},
                {2724286,95933727},
                {94953865,189383554},
                {64228444,111575063}};
        //int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        //int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(problem452.findMinArrowShots(points));
    }
}
