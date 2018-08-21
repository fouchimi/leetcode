public class Problem706 {

    static class MyHashMap {

        private static final int LIMIT = 1000000;
        /** Initialize your data structure here. */
        int[][] map;
        public MyHashMap() {
            map = new int[1][LIMIT];
            for(int i = 0; i < LIMIT; i++) map[0][i] = -1;
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            map[0][key]  = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return map[0][key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            map[0][key] = -1;
        }
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));

    }

}
