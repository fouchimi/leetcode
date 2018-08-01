public class Problem369 {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        head = reverse(head);
        ListNode current = head;
        current.val = current.val + 1;
        int carry;
        while (current.next != null) {
            if(current.val >= 10) {
                carry = current.val / 10;
                current.val = current.val % 10;
            }else carry = 0;
            current = current.next;
            current.val += carry;
        }

        if(current.val >= 10) {
            carry = current.val/10;
            current.val = current.val % 10;
            current.next = new ListNode(carry);
        }

        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    private void print(ListNode head) {
        ListNode current  = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem369 problem369 = new Problem369();
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(9);
        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(9);

        first = problem369.plusOne(first);
        problem369.print(first);

    }
}
