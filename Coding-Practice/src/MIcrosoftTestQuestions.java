import java.util.*;

public class MIcrosoftTestQuestions {

    public static int solution (int[] a, int[] b, int n) {
        if (n <= 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i ++) {
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < a.length; i++) {
            map.get(a[i]).add(b[i]);
            map.get(b[i]).add(a[i]);
        }

        int maxSize = 1;
        int val =1;
        PriorityQueue<Map.Entry<Integer, List<Integer>>> maxHeap = new PriorityQueue<Map.Entry<Integer, List<Integer>>>((i, j) ->j.getValue().size() - i.getValue().size());
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
           maxHeap.add(entry);
        }

        Set<Integer>  set = new HashSet<>();
        set.addAll(maxHeap.poll().getValue());
        set.addAll(maxHeap.poll().getValue());

        return set.size();
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,5};
        int[] b = {2,3,5,6};
        int n = 6;
        System.out.println(solution(a, b, n));
    }
}
