import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class BST_BottomView {
    static class Node {
        int data;
        Node leftSubtree;
        Node rightSubtree;

        public Node(int data) {
            this.data = data;
            this.leftSubtree = null;
            this.rightSubtree = null;
        }
    }

    static class Info {
        Node node;
        int horizontalDist;

        public Info(Node node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    public void bottomView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Info> qu = new LinkedList<>();
        qu.add(new Info(root, 0));
        while (!qu.isEmpty()) {
            Info temp = qu.poll();
            Node node = temp.node;
            int horizontalDist = temp.horizontalDist;
            hdMap.put(horizontalDist, node.data);
            if (node.leftSubtree != null) {
                qu.add(new Info(node.leftSubtree, horizontalDist - 1));

            }
            if (node.rightSubtree != null) {
                qu.add(new Info(node.rightSubtree, horizontalDist + 1));

            }
        }
        for (Map.Entry<Integer, Integer> entry : hdMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }

    public static void main(String[] args) {
        BST_BottomView bv = new BST_BottomView();
        Node root = new Node(1);
        root.leftSubtree = new Node(2);
        root.rightSubtree = new Node(3);
        root.leftSubtree.rightSubtree = new Node(4);
        root.leftSubtree.rightSubtree.rightSubtree = new Node(5);
        root.leftSubtree.rightSubtree.rightSubtree.rightSubtree = new Node(6);
        System.out.println("Bottom view of the binary search tree:");
        bv.bottomView(root);

    }
}
