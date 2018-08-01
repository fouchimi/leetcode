import java.util.Stack;

public class Problem388 {

    public int lengthLongestPath(String input) {
        String[] names = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (String name: names){
            // Count the level by counting number of tabs
            int level = 0;
            while (name.startsWith("\t")){
                name = name.substring(1);
                level++;
            }

            // Exit to the current level
            while (stack.size() - 1 > level){
                stack.pop();
            }

            if (name.contains(".")){
                // Is a file
                max = Math.max(max, stack.peek() + name.length());

            } else{
                // Is a directory
                stack.push(stack.peek() + name.length() + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem388 problem388 = new Problem388();
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(problem388.lengthLongestPath(path));

    }
}
