public class Problem657 {

    public boolean judgeCircle(String moves) {
        int leftRightCount = 0, upDownCount = 0;
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'U') upDownCount++;
            else if(moves.charAt(i) == 'D') upDownCount--;
            else if(moves.charAt(i) == 'R') leftRightCount++;
            else leftRightCount--;
        }

        return upDownCount == 0 && leftRightCount == 0;
    }

    public static void main(String[] args) {
        Problem657 problem657 = new Problem657();
        System.out.println(problem657.judgeCircle("UD"));
        System.out.println(problem657.judgeCircle("LL"));
    }
}
