


package AVLTree;
public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        try {
            avlTree.insert(10);
            avlTree.insert(5);
            avlTree.insert(15);
            avlTree.insert(3);
            avlTree.insert(7);
            avlTree.insert(12);
            avlTree.insert(17);
            System.out.println("Árbol AVL original:");
            avlTree.printTree();
            avlTree.delete(7);
            System.out.println("\nÁrbol AVL después de eliminar 7:");
            avlTree.printTree();
            avlTree.delete(10);
            System.out.println("\nÁrbol AVL después de eliminar 10:");
            avlTree.printTree();
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
    }
}
