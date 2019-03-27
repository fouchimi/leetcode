import java.util.*;

public class Problem621 {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0 || n == 0) return tasks.length;
        Map<Character, Integer> taskCount = new HashMap<>();
        for(Character task : tasks) taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> taskPoll = new PriorityQueue<>((firstTask, secondTask) -> secondTask.getValue() - firstTask.getValue());

        taskPoll.addAll(taskCount.entrySet());

        int intervals = 0;
        while(!taskPoll.isEmpty()) {
            List<Map.Entry<Character, Integer>> taskInPeriod = new ArrayList<>();
            int period = n + 1;
            while(period > 0 && !taskPoll.isEmpty()) {
                Map.Entry<Character, Integer> currentTask = taskPoll.poll();
                currentTask.setValue(currentTask.getValue()-1);
                taskInPeriod.add(currentTask);
                intervals++;
                period--;
            }

            for(Map.Entry<Character, Integer> remainedTask : taskInPeriod) {
                if(remainedTask.getValue() > 0) taskPoll.add(remainedTask);
            }

            if(taskPoll.isEmpty()) break;
            else if(period > 0) intervals += period;
        }
        return intervals;
    }

    public static void main(String[] args) {
        Problem621 problem621 = new Problem621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(problem621.leastInterval(tasks, 2));
    }


}
