public class Problem246 {

    public boolean isStrobogrammatic(String num) {

        if(num == null || num.isEmpty()) return false;

        StringBuilder leftSubStr = new StringBuilder();
        StringBuilder rightSubStr = new StringBuilder();

        for(int i = 0, j = num.length()-1; i <= j; i++, j--) {
            char leftChar = num.charAt(i);
            char rightChar = num.charAt(j);
            if(i == j) {
                if(leftChar == '0' || leftChar == '1' || leftChar == '8') rightSubStr.insert(0, leftChar);
                break;
            }
            else if(leftChar == '0') rightSubStr.insert(0, '0');
            else if(leftChar == '1') rightSubStr.insert(0, '1');
            else if(leftChar == '6') rightSubStr.insert(0, '9');
            else if(leftChar == '8') rightSubStr.insert(0, '8');
            else if(leftChar == '9') rightSubStr.insert(0, '6');
            if(rightChar == '0') leftSubStr.append('0');
            else if(rightChar == '1') leftSubStr.append('1');
            else if(rightChar == '6') leftSubStr.append('9');
            else if(rightChar == '8') leftSubStr.append('8');
            else if(rightChar == '9') leftSubStr.append('6');
        }

        String result = leftSubStr.toString() + rightSubStr.toString();

        return result.equals(num);
    }

    public static void main(String[] args) {
        Problem246 problem246 = new Problem246();
        System.out.println(problem246.isStrobogrammatic("69"));
        System.out.println(problem246.isStrobogrammatic("88"));
        System.out.println(problem246.isStrobogrammatic("96"));
        System.out.println(problem246.isStrobogrammatic("962"));
        System.out.println(problem246.isStrobogrammatic("11"));
        System.out.println(problem246.isStrobogrammatic("101"));
        System.out.println(problem246.isStrobogrammatic("60809"));
    }
}
