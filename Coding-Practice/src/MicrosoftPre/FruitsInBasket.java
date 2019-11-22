package MicrosoftPre;

import java.util.HashMap;
import java.util.Map;

//904
public class FruitsInBasket {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length ==0) {
            return 0;
        }
        int maxFruitWeCanCollect = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int start  =0;
        for (int end = 0; end < tree.length;end++) {
            map.put(tree[end], end);
            if (map.size() >= 3) {
                int min = tree.length-1;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                start = min+1;
                map.remove(tree[min]);
            }
            maxFruitWeCanCollect = Math.max(maxFruitWeCanCollect, end -start);
        }
        return maxFruitWeCanCollect == Integer.MIN_VALUE ? 0 : maxFruitWeCanCollect;
    }
}
