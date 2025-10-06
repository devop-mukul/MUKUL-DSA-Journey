package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = val;
        children = new ArrayList<Node>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

public class nAryLevelOrderTraversal {

    public static void main(String[] args) {
        // Build the following n-ary tree:
        //         1
        //      /  |  \
        //     3   2   4
        //    / \
        //   5   6
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.children.add(node5);
        node3.children.add(node6);
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        nAryLevelOrderTraversal solver = new nAryLevelOrderTraversal();
        List<List<Integer>> result = solver.levelOrder(root);

        System.out.println(result); // Output: [[1], [3, 2, 4], [5, 6]]
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lt = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                lt.add(curr.val);

                List<Node> temp = curr.children;
                for (int j = 0; j < temp.size(); j++) {
                    q.add(temp.get(j));
                }
            }

            ans.add(lt);
        }
        return ans;
    }
}
