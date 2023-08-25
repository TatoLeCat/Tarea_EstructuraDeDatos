public class Main {
    public static void main(String[] args) {
        // Crear un árbol binario con valor de raíz 1
        BinaryTree<Integer> binaryTree = new BinaryTree<>(1);

        // Crear nodos y establecerlos como hijos
        TreeNode<Integer> root = binaryTree.getRoot();
        TreeNode<Integer> leftChild = new TreeNode<>(2);
        TreeNode<Integer> rightChild = new TreeNode<>(3);

        root.setLeft(leftChild);
        root.setRight(rightChild);

        // Imprimir la estructura del árbol
        System.out.println("Valor de la raíz: " + root.value());
        System.out.println("Valor del hijo izquierdo: " + root.left().value());
        System.out.println("Valor del hijo derecho: " + root.right().value());

        // Verificar si los nodos son hojas
        System.out.println("¿Es la raíz una hoja? " + root.isLeaf());
        System.out.println("¿Es el hijo izquierdo una hoja? " + root.left().isLeaf());
        System.out.println("¿Es el hijo derecho una hoja? " + root.right().isLeaf());

        // Establecer valores para los nodos hoja
        root.left().setValue(4);
        root.right().setValue(5);

        // Imprimir valores actualizados
        System.out.println("Valor actualizado del hijo izquierdo: " + root.left().value());
        System.out.println("Valor actualizado del hijo derecho: " + root.right().value());
    }
}
