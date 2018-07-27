import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem341 {

    public interface NestedInteger {
        public boolean isInteger();
        public  Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            initialize(nestedList);
        }

        private void initialize(List<NestedInteger> nestedList) {
            if(nestedList.isEmpty()) return;
            for(NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
                else initialize(nestedInteger.getList());
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

}
