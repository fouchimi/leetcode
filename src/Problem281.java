import java.util.ArrayList;
import java.util.List;

public class Problem281 {

    public static class ZigzagIterator {

        List<Integer> list;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            list = new ArrayList<>();
            int i = 0, j = 0;
            while (i < v1.size() && j < v2.size()) {
                list.add(v1.get(i++));
                list.add(v2.get(j++));
            }

            while (i < v1.size()) list.add(v1.get(i++));

            while (j < v2.size()) list.add(v2.get(j++));

        }

        public int next() {

            return list.remove(0);
        }

        public boolean hasNext() {

            return !list.isEmpty();
        }
    }

    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        List<Integer> second = new ArrayList<>();
        second.add(3);
        second.add(4);
        second.add(5);
        second.add(6);

        ZigzagIterator zigzagIterator = new ZigzagIterator(first, second);
        while (zigzagIterator.hasNext()) System.out.print(zigzagIterator.next() + " ");
    }
}
