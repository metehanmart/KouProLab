
package lab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class GraphWeighted {
    private Set<NodeWeighted> nodes;
    private boolean directed;
    

    GraphWeighted(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }
    
    
    public void addNode(NodeWeighted... n) {
    
    nodes.addAll(Arrays.asList(n));
    }

    public void addEdge(NodeWeighted source, NodeWeighted destination, double weight) {
    
    nodes.add(source);
    nodes.add(destination);

    
    addEdgeHelper(source, destination, weight);

    if (!directed && source != destination) {
        addEdgeHelper(destination, source, weight);
    }
}

    private void addEdgeHelper(NodeWeighted a, NodeWeighted b, double weight) {
   
    for (EdgeWeighted edge : a.edges) {
        if (edge.source == a && edge.destination == b) {
           
            edge.weight = weight;
            return;
        }
    }
 
    a.edges.add(new EdgeWeighted(a, b, weight));
    }

    public void printEdges() {
    for (NodeWeighted node : nodes) {
        LinkedList<EdgeWeighted> edges = node.edges;

        if (edges.isEmpty()) {

            continue;
        }


        for (EdgeWeighted edge : edges) {

        }

    }
    }
    public boolean hasEdge(NodeWeighted source, NodeWeighted destination) {
    LinkedList<EdgeWeighted> edges = source.edges;
    for (EdgeWeighted edge : edges) {
       
        if (edge.destination == destination) {
            return true;
        }
    }
    return false;
}
    public void resetNodesVisited() {
    for (NodeWeighted node : nodes) {
        node.unvisit();
    }
    }
    public String DijkstraShortestPath(NodeWeighted start, NodeWeighted end) {
   
    HashMap<NodeWeighted, NodeWeighted> changedAt = new HashMap<>();
    changedAt.put(start, null);

    
    HashMap<NodeWeighted, Double> shortestPathMap = new HashMap<>();

   
    for (NodeWeighted node : nodes) {
        if (node == start)
            shortestPathMap.put(start, 0.0);
        else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
    }

    
    for (EdgeWeighted edge : start.edges) {
        shortestPathMap.put(edge.destination, edge.weight);
        changedAt.put(edge.destination, start);
    }

    start.visit();

   
    while (true) {
        NodeWeighted currentNode = closestReachableUnvisited(shortestPathMap);
        
        if (currentNode == null) {
            //System.out.println("There isn't a path between " + start.name + " and " + end.name);
            return null;
        }

       
        if (currentNode == end) {


            NodeWeighted child = end;

           
            String path = end.name;
            while (true) {
                NodeWeighted parent = changedAt.get(child);
                if (parent == null) {

                    return path;
                }

                
                path = parent.name + " " + path;
                child = parent;
            }

        }
        currentNode.visit();

        
        for (EdgeWeighted edge : currentNode.edges) {
            if (edge.destination.isVisited())
                continue;

            if (shortestPathMap.get(currentNode)
               + edge.weight
               < shortestPathMap.get(edge.destination)) {
                shortestPathMap.put(edge.destination,
                                   shortestPathMap.get(currentNode) + edge.weight);
                changedAt.put(edge.destination, currentNode);
            }
        }
    }
    }
    private NodeWeighted closestReachableUnvisited(HashMap<NodeWeighted, Double> shortestPathMap) {

    double shortestDistance = Double.POSITIVE_INFINITY;
    NodeWeighted closestReachableNode = null;
    for (NodeWeighted node : nodes) {
        if (node.isVisited())
            continue;

        double currentDistance = shortestPathMap.get(node);
        if (currentDistance == Double.POSITIVE_INFINITY)
            continue;

        if (currentDistance < shortestDistance) {
            shortestDistance = currentDistance;
            closestReachableNode = node;
        }
    }
    return closestReachableNode;
    }
   
}
