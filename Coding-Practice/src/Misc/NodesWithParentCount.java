package Misc;

import java.util.*;

public class NodesWithParentCount {
    public static List<Set<Integer>> find(int[][] input) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] array : input) {
            List<Integer> list = map.getOrDefault(array[1], new ArrayList<>());
            list.add(array[0]);
            map.put(array[1], list);
        }
        Set<Integer> nodesWithZeroParent = new HashSet<>();
        Set<Integer> nodesWithOneParent = new HashSet<>();
        for (int[] array : input) {
            for (int v : array) {
                if (!map.containsKey(v)) {
                    nodesWithZeroParent.add(v);
                    continue;
                }
                if (map.get(v).size() == 1) {
                    nodesWithOneParent.add(v);
                }
            }
        }

        List<Set<Integer>> result = new ArrayList<>();
        result.add(nodesWithOneParent);
        result.add(nodesWithZeroParent);
        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
        find(input);
    }
}
