package interview.excercise.chapter4.datastructures;

public class BinaryTreeNode<T> {
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public T data;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
