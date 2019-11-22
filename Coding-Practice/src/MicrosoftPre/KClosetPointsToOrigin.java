package MicrosoftPre;

import java.util.PriorityQueue;

public class KClosetPointsToOrigin {
    private class Node{
        int dist;
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((a, b) -> b.dist - a.dist);

        for (int i=0;  i < points.length; i++) {
            Node node = new Node(points[i][0], points[i][1]);
            node.dist = dist(points[i]);

            if (maxHeap.size() < K) {
                maxHeap.add(node);
            } else {
                if(node.dist < maxHeap.peek().dist) {
                    maxHeap.poll();
                    maxHeap.add(node);
                }
            }
        }
        int[][] result = new int[K][2];
        int index =0;
        for (int i = 0 ; i < K ; i++) {
            Node node = maxHeap.poll();
            int[] n = new int[2];
            n[0] = node.x;
            n[1] = node.y;
            result[index] = n;
            index++;
        }

        return result;

    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
