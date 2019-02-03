import java.util.ArrayDeque;
import java.util.Queue;

public class Problem286 {

    class Tuple {
        private int x, y;
        protected Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(rooms[i][j] == 0) {
                    boolean[][] visited = new boolean[rows][cols];
                    Queue<Tuple> queue = new ArrayDeque<>();
                    queue.add(new Tuple(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        Tuple top = queue.poll();
                        //Top neighbor
                        getNeighbors(queue, visited, top.x-1, top.y, rooms, top);
                        //Left neighbor
                        getNeighbors(queue, visited, top.x, top.y-1, rooms, top);
                        //Right neighbor
                        getNeighbors(queue, visited, top.x, top.y+1, rooms, top);
                        //Bottom neighbor
                        getNeighbors(queue, visited, top.x+1, top.y, rooms, top);
                    }
                }
            }
        }
    }

    private void getNeighbors(Queue<Tuple> queue, boolean[][] visited, int row, int col, int[][] rooms, Tuple parent) {
        if(row < 0 || row > rooms.length-1 || col < 0 || col > rooms[0].length-1 || rooms[row][col] == -1 || rooms[row][col] == 0 || visited[row][col]) return;
        queue.add(new Tuple(row, col));
        visited[row][col] = true;
        rooms[row][col] = Math.min(rooms[parent.x][parent.y]+1, rooms[row][col]);
    }

    public static void main(String[] args) {
        Problem286 problem286 = new Problem286();
        int[][] rooms = {
                         {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                         {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                         {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                         {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
                        };
        problem286.wallsAndGates(rooms);
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
