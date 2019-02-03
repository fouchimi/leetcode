import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Problem379 {

    private List<Integer> list;

    public Problem379(int maxNumbers){
        list = new LinkedList<>();
        for(int i = 0; i < maxNumbers; i++) list.add(i);
    }

    public int get() {
        if(list.isEmpty()) return -1;
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.remove(index);
    }

    public boolean check(int number) {
        return !list.isEmpty() && list.contains(number);
    }

    public void release(int number) {
        if(list.contains(number)) return;
        list.add(number);
    }

    public static void main(String[] args) {
        Problem379 problem379 = new Problem379(3);
        int first = problem379.get();
        System.out.println(first);
        int second = problem379.get();
        System.out.println(second);
        problem379.release(first);
        System.out.println(problem379.check(second));
    }

}
