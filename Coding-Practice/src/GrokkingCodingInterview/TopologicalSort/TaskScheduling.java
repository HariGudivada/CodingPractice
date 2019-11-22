package GrokkingCodingInterview.TopologicalSort;

import java.util.*;

public class TaskScheduling {
    public boolean taskScheduling(int tasks, int[][] prerequisites) {
        if (tasks <= 0) {
            return true;
        }

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            adjMap.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            adjMap.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int child : inDegree.keySet()) {
            if (inDegree.get(child) == 0) {
                queue.add(child);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        List<Integer> topologicalSort = new ArrayList<>();
        while(!queue.isEmpty()) {
            int source = queue.poll();
            topologicalSort.add(source);
            for (int child : adjMap.get(source)) {
                inDegree.put(source, inDegree.get(source)-1);
                if (inDegree.get(source) == 0) {
                    queue.add(child);
                }
            }
        }

        return topologicalSort.size() == tasks;
    }
}
