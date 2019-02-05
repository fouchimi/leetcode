

public class Problem445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode currentFirst = l1, currentSecond = l2, head = new ListNode(Integer.MIN_VALUE), dummy = head;
        int carry = 0;

        while (currentFirst != null && currentSecond != null) {
            int sum = currentFirst.val + currentSecond.val + carry;
            if(sum > 9) {
                carry = sum/10;
                sum %= 10;
            } else carry = 0;

            head.next = new ListNode(sum);
            head = head.next;
            currentFirst = currentFirst.next;
            currentSecond = currentSecond.next;
        }

        while (currentFirst != null) {
            int sum = currentFirst.val + carry;
            if(sum > 9) {
                carry = sum/10;
                sum %= 10;
            } else carry = 0;
            head.next = new ListNode(sum);
            head = head.next;
            currentFirst = currentFirst.next;
        }

        while (currentSecond != null) {
            int sum = currentSecond.val + carry;
            if(sum > 9) {
                carry = sum/10;
                sum %= 10;
            } else carry = 0;
            head.next = new ListNode(sum);
            head = head.next;
            currentSecond = currentSecond.next;
        }

        if(carry > 0) head.next = new ListNode(carry);

        head = reverseList(dummy.next);

        return head;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head, temp = null;
        while (current != null) {
            temp = prev;
            prev = current;
            current = current.next;
            prev.next = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Problem445 problem445 = new Problem445();
        ListNode firstList = new ListNode(7);
        firstList.next = new ListNode(2);
        firstList.next.next = new ListNode(4);
        firstList.next.next.next = new ListNode(3);

        ListNode secondList = new ListNode(5);
        secondList.next = new ListNode(6);
        secondList.next.next = new ListNode(4);

        secondList = problem445.addTwoNumbers(firstList, secondList);
        problem445.print(secondList);

//        problem445.print(firstList);
//        firstList = problem445.reverseList(firstList);
//        problem445.print(firstList);
    }

}
