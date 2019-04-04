import java.util.ArrayList;
import java.util.List;

public class Problem60 {

    public String permutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        int[] factorials = new int[n+1];
        List<Integer> list = new ArrayList<>();

        factorials[0] = 1;
        int sum = 1;
        for(int i = 1; i <= n; i++) {
            sum *= i;
            factorials[i] = sum;
        }

        // Create a list of numbers to get indexes
        for(int i = 1; i <= n; i++) list.add(i);

        k--;
        for(int i = 1; i <= n; i++) {
            int index = k/factorials[n-i];
            sb.append(list.get(index));
            list.remove(index);
            k = k - index * factorials[n-i];
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Problem60 problem60 = new Problem60();
        System.out.println(problem60.permutation(4, 9));
    }
}
