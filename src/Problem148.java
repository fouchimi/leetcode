public class Problem148 {

    private int size = 0;

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) { this.val = val; }
    }

    public ListNode sortList(ListNode head) {

        ListNode current = head, dummy = new ListNode(Integer.MIN_VALUE);
        int N = 0;
        while (current != null) {
            N++;
            current = current.next;
        }

        int[] pq = new int[N+1];
        current = head;
        while (current != null) {
            pq[++size] = current.val;
            swim(pq, size);
            current = current.next;
        }

        while(size > 0) {
            int minValue = pq[1];
            ListNode cur = new ListNode(minValue);
            if(dummy.next == null) {
                dummy.next = cur;
                current = cur;
            }else {
                current.next = cur;
                current = current.next;
            }

            pq[1] = pq[size--];
            pq[size + 1] = '\0';
            sink(pq, 1);

        }

        return dummy.next;
    }

    private void sink(int[] pq, int k) {
        while (2*k <= size) {
            int j = 2*k;
            if(j < size && less(pq, j+1, j)) j++;
            if(!less(pq, j, k)) break;
            exch(pq, j, k);
            k = j;
        }
    }

    private void swim(int[] pq, int k) {
        while (k > 1 && less(pq, k, k/2)) {
            exch(pq, k, k/2);
            k = k/2;
        }
    }

    private boolean less(int[] pq, int p, int q) {
        return pq[p] < pq[q];
    }

    private void exch(int[] pq, int p, int q) {
        int temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }

    private void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Problem148 problem148 = new Problem148();
        ListNode first = new ListNode(4);
        first.next = new ListNode(2);
        first.next.next = new ListNode(1);
        first.next.next.next = new ListNode(3);

        ListNode head = problem148.sortList(first);
        problem148.print(head);
    }
}
