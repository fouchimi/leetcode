import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem212 {

    public List<String> findWords(char[][] board, String[] words) {
        boolean[] visited = new boolean[(board.length * board[0].length) + 1];
        Set<String> set = new HashSet<>();
        for(String word : words) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(word.charAt(0) == board[i][j]) {
                        dfs(word, board, visited, i, j, set, 0);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>(set);
        return list;
    }

    private void dfs(String word, char[][] board, boolean[] visited, int row, int col,  Set<String> list, int index) {
        if(index > word.length() || list.contains(word)) return;
        else if(index == word.length()) list.add(word);
        else if(isValid(board, row, col)) {
            int i = getRelativeIndex(board, row, col);
            if(!visited[i] && word.charAt(index) == board[row][col]) {
                visited[i] = true;
                dfs(word, board, visited, row+1, col, list, index+1);
                dfs(word, board, visited, row, col+1, list, index+1);
                dfs(word, board, visited, row-1, col, list, index+1);
                dfs(word, board, visited, row, col-1, list, index+1);
                visited[i] = false;
            }

        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1) return false;
        return true;
    }

    private int getRelativeIndex(char[][] board, int row, int col) {
        return row * board[0].length + col;
    }

    public static void main(String[] args) {
        Problem212 problem212 = new Problem212();
        /*char[][] board = {{'o', 'a', 'a', 'n'},
                          {'e', 't', 'a', 'e'},
                          {'i', 'h', 'k', 'r'},
                          {'i', 'f', 'l', 'v'}}; */
        /*char[][] board = {{'b'},
                          {'a'},
                          {'b'},
                          {'b'},
                          {'a'}};
        String[] words = {"baa", "abba", "baab", "aba"}; */
        //String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a', 'b'},
                          {'c', 'd'}};
        String[] words = {"acdb"};
        System.out.println(problem212.findWords(board, words));
    }
}
