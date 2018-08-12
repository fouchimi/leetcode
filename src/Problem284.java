import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem284 {

    public static class PeekingIterator implements Iterator<Integer> {

        List<Integer> list;
        public PeekingIterator(Iterator<Integer> iterator) {
            list = new ArrayList<>();
            while (iterator.hasNext()) list.add(iterator.next());
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(0);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(list.isEmpty()) return null;
            return list.remove(0);
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }

}
