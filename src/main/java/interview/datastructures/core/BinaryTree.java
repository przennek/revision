package interview.datastructures.core;

import interview.algo.QSort;
import interview.datastructures.interf.List;

import java.util.Optional;

public class BinaryTree<T> extends Tree<T> {

    private BinaryTree(final Node<T> baseTree) {
        super(baseTree);
    }

    public static <T extends Comparable<T>> BinaryTree<T> construct(LinkedList<T> values) {
        QSort.sort(values);
        return new BinaryTree<>(constructBinaryNodes(values));
    }

    private static <T extends Comparable<T>> Node<T> constructBinaryNodes(List<T> values) {

        if (values.isEmpty()) {
            return null;
        }

        int middleIndex = values.size() / 2;
        SPair<List<T>> split = values.split(middleIndex);
        T middleValue = split.getLeft().removeAt(middleIndex);

        TreeBuilder<T> builder = builder();
        TreeBuilder<T> leaf = builder.nodeValue(new Node<>(null, middleValue))
                .leaf(constructBinaryNodes(split.getLeft()))
                .leaf(constructBinaryNodes(split.getRight()));

        return leaf.<T>buildNode();
    }

    public void invert() {
        this.dfTraversal(it -> {
            LinkedList<Node<T>> kinder = it.getLeafs();
            if(kinder.size() < 2) {
                return Optional.empty();
            }
            kinder.swap(0, 1);
            return Optional.empty();
        });
    }

}
