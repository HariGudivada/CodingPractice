package LeetCode;

import java.util.*;

/**
 * 253
 */
public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        int ps = prev[0];
        int pe = prev[1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[1] <= pe) {
                count++;
                pe = Math.min(pe, curr[1]);
            } else {
                pe = curr[1];
//                count--;
            }
        }

        return count <= 1 ? 1: count;
    }

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l2.add(1);
        l2.add(2);
        set.add(l1);
        set.add(l2);
        System.out.println(set.size());
        int[][] a = {{0,30},{5,10},{15,20}};
        minMeetingRooms(a);
    }
}
