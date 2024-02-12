package interview.datastructures.core;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

public class Tree<T> {

    private final Node<T> root;

    public Tree(T rootValue) {
        this.root = new Node<>(null, rootValue);
    }

    protected Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Optional<Node<T>> dfTraversal(Function<Node<T>, Optional<Node<T>>> sideEffect) {
        return dfTraversal(sideEffect, root);
    }

    public Optional<Node<T>> bfTraversal(Function<Node<T>, Optional<Node<T>>> sideEffect) {
        return bfTraversal(sideEffect, new LinkedList<>(root));
    }

    private Optional<Node<T>> dfTraversal(Function<Node<T>, Optional<Node<T>>> sideEffect, Node<T> node) {
        Optional<Node<T>> result = sideEffect.apply(node);
        if (result.isPresent()) {
            return result;
        }
        for (Iterator<LinkedList.Node<Node<T>>> itc = node.getLeafs().iterator(); itc.hasNext(); ) {
            Node<T> next = itc.next().val();
            Optional<Node<T>> tNode = dfTraversal(sideEffect, next);
            if (tNode.isPresent()) {
                return tNode;
            }
        }
        return Optional.empty();
    }

    private Optional<Node<T>> bfTraversal(Function<Node<T>, Optional<Node<T>>> sideEffect,
                                          LinkedList<Node<T>> nodes) {

        LinkedList<Node<T>> nextRow = new LinkedList<>();
        for (Iterator<LinkedList.Node<Node<T>>> itc = nodes.iterator(); itc.hasNext(); ) {
            Node<T> tNode = itc.next().val();
            Optional<Node<T>> result = sideEffect.apply(tNode);
            if (result.isPresent()) {
                return result;
            }
            nextRow.addAll(tNode.getLeafs());
        }

        if (nextRow.isEmpty()) {
            return Optional.empty();
        }

        return bfTraversal(sideEffect, nextRow);
    }


    public static <T> TreeBuilder<T> builder() {
        return new TreeBuilder<T>();
    }

    public static class TreeBuilder<T> {

        private Node<T> parent;
        private LinkedList<Node<T>> leafs = new LinkedList<>();

        public Tree<T> buildTree() {
            Tree<T> tTree = new Tree<>(parent.getValue());
            tTree.getRoot().leafs = leafs;
            return tTree;
        }

        public Node<T> buildNode() {
            Tree<T> tTree = new Tree<>(parent.getValue());
            tTree.getRoot().leafs = leafs;
            return tTree.getRoot();
        }

        public TreeBuilder<T> value(T value) {
            this.parent = new Node<>(null, value);
            return this;
        }

        // Java generics should be remade
        public TreeBuilder<T> nodeValue(Node<T> nodeValue) {
            this.parent = nodeValue;
            return this;
        }

        public TreeBuilder<T> leaf(Node<T> value) {
            if (value != null) {
                Node<T> val = new Node<>(parent, value.getValue());
                leafs.add(val);
                val.leafs = value.leafs;
            }
            return this;
        }
    }

    public static class Node<T> {
        private final Node<T> parent;
        private final T value;
        private LinkedList<Node<T>> leafs;

        protected Node(final Node<T> parent, final T value) {
            this.parent = parent;
            this.value = value;
            this.leafs = new LinkedList<>();
        }

        public void addChild(Node<T> v) {
            leafs.add(v);
        }

        public Optional<Node<T>> getParent() {
            return Optional.ofNullable(parent);
        }

        public T getValue() {
            return value;
        }

        public LinkedList<Node<T>> getLeafs() {
            return leafs;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other instanceof Node) {
                return ((Node) other).getValue().equals(getValue());
            }
            return false;
        }
    }
}
