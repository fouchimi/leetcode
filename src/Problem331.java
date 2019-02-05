public class Problem331 {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes) {
            if(--diff < 0) return false;
            if(!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        Problem331 problem331 = new Problem331();
        System.out.println(problem331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(problem331.isValidSerialization("1,#"));
    }
}
