import java.util.LinkedList;
import java.util.List;

public class Problem705 {

    static class MyHashSet {

        /** Initialize your data structure here. */
        List<Integer> list;
        public MyHashSet() {
            list = new LinkedList<>();
        }

        public void add(int key) {
            Integer integer = new Integer(key);
            if(!list.contains(integer)) list.add(integer);
        }

        public void remove(int key) {
            Integer integer = new Integer(key);
            if(list.contains(integer)) list.remove(integer);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            Integer integer = new Integer(key);
            return list.contains(integer);
        }
    }

    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
