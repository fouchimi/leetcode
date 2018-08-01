import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem251 {

    public static class Vector2D implements Iterator<Integer> {

        List<Integer> list = new ArrayList<>();
        public Vector2D(List<List<Integer>> vec2d) {
            for(List<Integer> eachList : vec2d) {
                list.addAll(eachList);
            }
        }

        @Override
        public Integer next() {
            return list.remove(0);
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        List<Integer> secondList = new ArrayList<>();
        secondList.add(3);
        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(4);
        thirdList.add(5);
        thirdList.add(6);
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(firstList);
        resultList.add(secondList);
        resultList.add(thirdList);
        Vector2D vector2D = new Vector2D(resultList);

        while (vector2D.hasNext()) {
            System.out.print(vector2D.next() + " ");
        }
    }
}
