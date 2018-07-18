import java.util.Stack;

public class Problem71 {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder reducedPath = new StringBuilder();
        for(String p : paths) {
            if(p.equals("/") || p.length() == 0 || p.equals(".")) continue;
            if(stack.isEmpty()) stack.push(p);
            else if(p.equals("..") && !stack.isEmpty()) stack.pop();
            else {
                if(stack.peek().equals("..")) stack.pop();
                stack.push(p);
            }
        }
        if(!stack.isEmpty() && stack.peek().equals("..")) stack.pop();
        if(stack.isEmpty()) return "/";
        while (!stack.isEmpty()) reducedPath.insert(0, "/" + stack.pop());

        return reducedPath.toString();
    }

    public static void main(String[] args) {
        Problem71 problem71 = new Problem71();
        String path = "/home//foo/";
        System.out.println(problem71.simplifyPath(path));
    }
}
