import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem690 {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

    }

    public int getImportance(List<Employee> employees, int id) {

        Queue<Employee> queue = new ArrayDeque<>();
        Employee selectedEmployee = null;
        for(Employee eachEmployee : employees) {
            if(eachEmployee.id == id) {
                selectedEmployee = eachEmployee;
                break;
            }
        }
        queue.offer(selectedEmployee);
        employees.remove(selectedEmployee);
        int sum = 0;

        while (!queue.isEmpty()) {
            Employee topEmployee = queue.poll();
            sum += topEmployee.importance;
            for(Integer subordinateId : topEmployee.subordinates) {
                for(Employee employee : employees) {
                    if(subordinateId == employee.id) queue.add(employee);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Problem690 problem690 = new Problem690();
        List<Integer> listA = new ArrayList<>();
        listA.add(2);
        listA.add(3);
        Employee firstEmployee = new Employee(1, 5, listA);

        List<Integer> listB = new ArrayList<>();
        Employee secondEmployee = new Employee(2, 3, listB);

        List<Integer> listC = new ArrayList<>();
        Employee thirdEmployee = new Employee(3, 3, listC);

        List<Employee> list = new ArrayList<>();
        list.add(firstEmployee);
        list.add(secondEmployee);
        list.add(thirdEmployee);
        System.out.println(problem690.getImportance(list, 1));
    }

}
