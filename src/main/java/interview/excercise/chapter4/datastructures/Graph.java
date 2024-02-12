package interview.excercise.chapter4.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Node> nodes;

    public static class Node {
        public int id;
        public List<Node> children;

        public Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }

        public void addChild(Node c) {
            this.children.add(c);
        }
    }
}
