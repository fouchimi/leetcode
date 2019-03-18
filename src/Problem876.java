public class Problem876 {

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        int N = 0;
        ListNode current = head;
        while (current != null) {
            N++;
            current = current.next;
        }

        int mid = N/2;

        current = head;
        while (mid > 0 && current != null) {
            mid--;
            current = current.next;
        }

        return current;
    }

    private void print(ListNode x) {
        if(x == null) return;
        ListNode cursor = x;
        while (cursor != null) {
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Problem876 problem876 = new Problem876();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next =new ListNode(6);

        ListNode ans = problem876.middleNode(head);
        problem876.print(ans);
    }
}
