import java.util.Arrays;

public class Problem556 {

    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i, j;
        /*
           Start from the right most digit and find the
           first digit that is smaller than the digit next to it
         */
        for(i = digits.length-1; i > 0; i--) {
            if(digits[i-1] < digits[i]) break;
        }

        // If no such digit is found, its the edge case 1
        if(i == 0) return -1;
        int x = digits[i-1], smallest = i;
        for(j = i+1; j < digits.length; j++)
            if(digits[j] > x && digits[j] <= digits[smallest])
                smallest = j;

        // III) Swap the above found smallest digit with  digit[i-1]
        char temp = digits[i-1];
        digits[i-1] = digits[smallest];
        digits[smallest] = temp;

        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(digits, i, digits.length);
        long val = Long.parseLong(String.valueOf(digits));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    public static void main(String[] args) {
        Problem556 problem556 = new Problem556();
        System.out.println(problem556.nextGreaterElement(12));
        System.out.println(problem556.nextGreaterElement(21));
        System.out.println(problem556.nextGreaterElement(1));
        System.out.println(problem556.nextGreaterElement(1234));
        System.out.println(problem556.nextGreaterElement(101));
        System.out.println(problem556.nextGreaterElement(230241));
    }
}
