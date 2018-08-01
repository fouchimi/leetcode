public class Problem208 {

    private static class Node {
        private String val;
        private Node[] next = new Node[26];
    }

    public static class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            root = insert(root, word, word, 0);
        }

        private Node insert(Node x, String key, String value,  int d) {
            if(x == null) x = new Node();
            if(d == key.length()) {
                x.val = value;
                return x;
            }
            char ch = key.charAt(d);
            int index = ch - 'a';
            x.next[index] = insert(x.next[index], key, value, d+1);
            return x;
        }

        public boolean search(String word) {
            Node x = search(root, word, 0);
            if(x == null || x.val == null) return false;
            return x.val.equals(word);
        }

        private Node search(Node x, String value, int d) {
            if(x == null) return null;
            if(d == value.length()) return x;
            char ch = value.charAt(d);
            int index = ch - 'a';
            return search(x.next[index], value, d+1) ;
        }

        public boolean startsWith(String prefix) {
            Node x = startsWith(root, prefix, 0);
            if(x == null) return false;
            return true;
        }

        private Node startsWith(Node x, String key, int d) {
            if(x == null) return null;
            if(d == key.length()) return x;
            char ch = key.charAt(d);
            int index = ch - 'a';
            return startsWith(x.next[index], key, d+1);
        }
    }

    public static void main(String[] args) {
        Problem208 problem208 = new Problem208();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
