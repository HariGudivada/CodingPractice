package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70
 */
public class ClimbingStairs {
    private static Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        int count = 0;
        return helper(n, count);
    }

    private static int helper(int num, int count) {
        if(map.get(num) != null) {
            return map.get(num);
        }

        int num2 = num - 2;
        int num1 = num - 1;
        if (map.get(num2) == null) {
            map.put(num2, helper(num2, count));
        }

        if(map.get(num1) == null) {
            map.put(num1, helper(num1, count));
        }

        return map.get(num2)+ map.get(num1);
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2));
    }
}
