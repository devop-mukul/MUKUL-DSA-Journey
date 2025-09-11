package Graph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {
    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        // If the starting node is null, the clone must also be null.
        if (node == null) return null;

        // Check if the node has already been cloned.
        // The HashMap.containsKey() method checks for the key's existence.
        if (nodes.containsKey(node.val)) {
            // If it's already cloned, return the existing copy from the map.
            return nodes.get(node.val);
        }

        // This is the first time visiting this node.
        // Create a new node (the copy).
        Node copiedNode = new Node(node.val);
        // Add the newly created copy to the map to prevent re-cloning.
        nodes.put(node.val, copiedNode);

        // Iterate through all neighbors of the original node.
        for (Node neighbor : node.neighbors) {
            // Recursively call cloneGraph for each neighbor and add the
            // returned clone to our new node's neighbor list.
            copiedNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the new node, whose adjacency list is now fully copied.
        return copiedNode;
    }

    // Helper to build graph from adjacency list
    public static Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) return null;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjList.length; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < adjList.length; i++) {
            Node node = map.get(i + 1);
            for (int neighborVal : adjList[i]) {
                node.neighbors.add(map.get(neighborVal));
            }
        }
        return map.get(1); // return the node with value 1 as root
    }

    // Helper to print graph (BFS)
    public static void printGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node.val);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.val + " neighbors: ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        Node original = buildGraph(adjList);

        System.out.println("Original graph:");
        printGraph(original);

        CloneGraph cg = new CloneGraph();
        Node cloned = cg.cloneGraph(original);

        System.out.println("Cloned graph:");
        printGraph(cloned);
    }
}
