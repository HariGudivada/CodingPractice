import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    List<Integer> list ;
    private StackUsingArrayList(final int capacity) {
        list = new ArrayList<>(capacity);
    }

    public void push(final int element) {
        list.add(element);
    }

    public int pop() {
        return list.remove(list.size() - 1);
    }

    public int peek () {
        return list.get(list.size()-1);
    }
}
