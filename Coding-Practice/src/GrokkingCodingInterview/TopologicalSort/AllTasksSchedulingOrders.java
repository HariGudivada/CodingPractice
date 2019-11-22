package GrokkingCodingInterview.TopologicalSort;

import java.util.*;

public class AllTasksSchedulingOrders {
    public void schedulingOrders(int n, int[][] prerequisites) {
        if (n <= 0) {
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList());
            inDegree.put(i, 0);
        }

        for (int[] arr : prerequisites) {
            int parent = arr[0], child = arr[1];
            map.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        addTopologicalSort(sortedOrder, sources, map, inDegree);
    }

    private void addTopologicalSort(List<Integer> sortedOrder, Queue<Integer> sources, Map<Integer, List<Integer>> map, Map<Integer, Integer> inDegree) {
        if (!sources.isEmpty()) {
            for (int vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextIteration = cloneQueue(sources);
                sourcesForNextIteration.remove(vertex);

                List<Integer> childs = map.get(vertex);
                for (int child : childs) {
                    inDegree.put(child, inDegree.get(child)-1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextIteration.add(child);
                    }
                }
            addTopologicalSort(sortedOrder, sourcesForNextIteration, map, inDegree);
                sortedOrder.remove(vertex);
                for (int child : map.get(vertex)) {
                    inDegree.put(child, inDegree.get(child)+1);
                }
            }
        }

        if (sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }
    }

    public Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        clone.addAll(queue);

        return clone;
    }
}
