package GrokkingCodingInterview.TopologicalSort;

import java.util.*;

public class TopologicalSort {
    public List<Integer> topologicalSort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return Collections.emptyList();
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i =0; i < vertices; i++) {
            inDegree.put(i, 0);
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            adjMap.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (int child : inDegree.keySet()) {
            // if a vertex have zero incoming edges then it will be a source.
            if (inDegree.get(child) == 0) {
                sources.add(child);
            }
        }

        if (sources.isEmpty()) {
            return Collections.emptyList();
        }

        while (!sources.isEmpty()) {
            int source = sources.poll();
            for (int child : adjMap.get(source)) {
                inDegree.put(child, inDegree.get(child)-1);
                if (inDegree.get(child) == 0) {
                    sources.offer(child);
                }
            }
            sortedOrder.add(source);
        }
        if (sortedOrder.size() != vertices) {
            return Collections.emptyList();
        }

        return sortedOrder;
    }
}
