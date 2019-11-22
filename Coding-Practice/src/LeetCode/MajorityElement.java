package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int result = 0 ;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            int count = map.get(num);
            if (count > maxCount) {
                maxCount = count;
                result = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {6,5,5};
        System.out.println(majorityElement(array));
    }

}
