public class Interval {

    public int start, end;
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
        return "[" + this.start + "," + this.end + "]";
    }
}
