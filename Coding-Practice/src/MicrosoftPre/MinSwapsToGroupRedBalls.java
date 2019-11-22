package MicrosoftPre;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/414660/
 */
public class MinSwapsToGroupRedBalls {
    public int minSwaps (String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        List<Integer> redIndices = new ArrayList<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                redIndices.add(i);
            }
        }
        int mid = redIndices.size()/2;
        int result = 0;
        for (int i = 0; i < redIndices.size(); i++) {
            result += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "RRRWRR";
        MinSwapsToGroupRedBalls minSwapsToGroupRedBalls = new MinSwapsToGroupRedBalls();
        System.out.println(minSwapsToGroupRedBalls.minSwaps(s));
    }
}
