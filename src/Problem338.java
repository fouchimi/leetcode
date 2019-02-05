public class Problem338 {

    public int[] countBits(int num) {

        if(num == 0) return new int[]{0};
        int[] count = new int[num+1];
        for(int i = 0; i < count.length; i++) {
            int N = i, counter = 0;
            while (N > 0) {
                if((N & 1) == 1) counter++;
                N >>= 1;
            }
            count[i] = counter;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem338 problem338 = new Problem338();
        int[] result = problem338.countBits(5);
        for(int num : result) System.out.print(num + " ");
    }
}
