public class Problem346 {


    int N;
    int[] arr;

    public Problem346(int size) {
        N = 0;
        arr = new int[size];
    }

    public double next(int val) {
        if (N < arr.length) arr[N++] = val;
        else {
            for(int i = 1; i < N; i++) arr[i-1] = arr[i];
            arr[N-1] = val;
        }
        double sum = 0.0;
        for(int i = 0; i < N; i++) sum += arr[i];
        return sum / N;
    }

    public static void main(String[] args) {
        Problem346 problem346 = new Problem346(3);
        System.out.println(problem346.next(1));
        System.out.println(problem346.next(10));
        System.out.println(problem346.next(3));
        System.out.println(problem346.next(5));
    }
}
