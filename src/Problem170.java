
public class Problem170 {

    int N;
    private int[] arr;

    Problem170 () {
        N = 0;
        arr = new int[1];
    }

    public void add(int number) {
        if(isFull()) {
            int[] newArr = new int[2*N];
            for(int i = 0; i < N; i++) newArr[i] = arr[i];
            arr = newArr;
        }
        int i = 0;
        for(; i < N; i++) {
            if(number <= arr[i]) {
                for(int j = N; j > i; j--) arr[j] = arr[j-1];
                break;
            }
        }
        arr[i] = number;
        ++N;
    }

    public boolean find(int value) {
        if(N < 2) return false;
        for(int i = 0; i < N; i++) {
            int index = find(arr, 0, N-1, value - arr[i]);
            if(index > -1 && index != i) return true;
        }
        return false;
    }

    private boolean isFull() {
        return N == arr.length;
    }

    private int find(int[] arr, int lo, int hi, int key) {
        if(lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(arr[mid] == key) return mid;
        else if(arr[mid] < key) return find(arr, mid+1, hi, key);
        else return find(arr, lo, mid-1, key);
    }


    public static void main(String[] args) {

        Problem170 problem170 = new Problem170();
        problem170.add(3);
        problem170.add(2);
        problem170.add(1);
        System.out.println(problem170.find(2));
        System.out.println(problem170.find(3));
        System.out.println(problem170.find(4));
        System.out.println(problem170.find(5));
        System.out.println(problem170.find(6));
    }
}
