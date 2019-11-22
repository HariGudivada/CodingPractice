import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DFSandBFS {
    Map<Integer, GraphNode> map = new HashMap<>();
    class GraphNode {
        int id;
        LinkedList<GraphNode> adjacent = new LinkedList<>();
         private GraphNode(int id) {
             this.id = id;
         }
    }

    private GraphNode getNode(int id) {
        return map.get(id);
    }

    private void addEdge(int source, int destination) {
        getNode(source).adjacent.add(getNode(destination));
    }

    public boolean hasPathDFS (int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        Set<GraphNode> visited = new HashSet<>();
        return hasPathDFS(s, d  , visited);
    }

    private boolean hasPathDFS (GraphNode source, GraphNode destination, Set<GraphNode> visited) {
        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);
        if (source == destination) {
            return true;
        }

        for (GraphNode child : source.adjacent) {
            if(hasPathDFS(child, destination, visited)) {
                return  true;
            }
        }
        return false;
    }
     private boolean hasPathBFS (GraphNode source, GraphNode destination) {
        Set<GraphNode> visited = new HashSet<>();
        LinkedList<GraphNode> nextToVisit = new LinkedList<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            GraphNode node = nextToVisit.remove();
            if (node == destination) {
                return true;
            }
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            for (GraphNode child : node.adjacent) {
                nextToVisit.add(child);
            }
        }

        return false;
     }
}
