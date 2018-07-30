import java.util.*;

public class Problem380 {

    private static class RandomizedSet {
        DNode header = new DNode(Integer.MIN_VALUE);
        DNode tail = new DNode(Integer.MAX_VALUE);
        Map<Integer, DNode> map;
        List<Integer> list;
        private static class DNode {
            DNode prev, next;
            int val;
            public DNode(){}
            public DNode(int val) {
                this.val = val;
            }
        }

        public RandomizedSet() {
            header.next = tail;
            tail.prev = header;
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            DNode newNode = new DNode(val);
            if(isEmpty()) {
                newNode.next = tail;
                newNode.prev = header;
                header.next = newNode;
                tail.prev = newNode;
            }else {
                newNode.next = header.next;
                header.next.prev = newNode;
                header.next = newNode;
                newNode.prev = header;
            }
            map.put(val, newNode);
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            System.out.println(list);
            DNode current = map.get(val);
            DNode prev = current.prev;
            prev.next = current.next;
            current.next = prev;
            current.prev = null;
            current.next = null;
            map.remove(val);
            list.remove(new Integer(val));
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if(list.isEmpty()) return 0;
            Random rand = new Random();
            int index = rand.nextInt(list.size());
            return list.get(index);
        }

        private boolean isEmpty() {
            return header.next == tail;
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(-1));
        System.out.println(randomizedSet.remove(-2));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(-1));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.getRandom());
    }

}
