class TreeNode<E> implements BinNode<E> {
    private E value;
    private BinNode<E> leftChild;
    private BinNode<E> rightChild;

    public TreeNode(E value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public E value() {
        return value;
    }

    @Override
    public void setValue(E v) {
        value = v;
    }

    @Override
    public BinNode<E> left() {
        return leftChild;
    }

    @Override
    public BinNode<E> right() {
        return rightChild;
    }

    @Override
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    // Setters for children
    public void setLeft(BinNode<E> left) {
        leftChild = left;
    }

    public void setRight(BinNode<E> right) {
        rightChild = right;
    }
}

public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree(E rootValue) {
        root = new TreeNode<>(rootValue);
    }

    public TreeNode<E> getRoot() {
        return root;
    }
}
