package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[1][1];
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            List<Integer> l = new ArrayList<>(2);
            if (curr[0] <= prev[1]) {
                int end = Math.max(prev[1], curr[1]);
                l.add(prev[0]);
                l.add(end);

            } else {
                l.add(curr[0]);
                l.add(curr[1]);
            }
            list.add(l);
        }
        int[][] result = new int[1][list.size()];
        for (int i = 0; i < list.size(); i++) {
            int[] arr =new int[2];
            arr[0] = list.get(i).get(0);
            arr[1] = list.get(i).get(1);
//            result[0][i] = arr;
        }

        return result;
    }
}
