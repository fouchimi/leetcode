public class Problem370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            for(int j = update[0]; j <= update[1]; j++ ) {
                res[j] += update[2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem370 problem370 = new Problem370();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int[] result = problem370.getModifiedArray(5, updates);
        for(int val : result) System.out.print(val + " ");
    }

}
