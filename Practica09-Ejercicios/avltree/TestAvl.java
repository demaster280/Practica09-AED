


package avltree;
import exceptions.ItemDuplicated;
import treelink.BSTree;
public class TestAvl {
    //Test NUMERO DOs - Ejercicios
	public static void main(String[] args) throws ItemDuplicated {
            
            System.out.println("\nEjercicio 1");
            BSTree<Integer> bst = new BSTree<>();
	    AVLTree<Integer> avl = new AVLTree<>();
	    
	    // Insertar elementos
	    bst.insert(2);
	    bst.insert(1);
	    bst.insert(3);
	    bst.insert(4);
	    bst.insert(8);
	    bst.insert(9);
	    bst.insert(10);

	    avl.insert(2);
	    avl.insert(1);
	    avl.insert(3);
	    avl.insert(4);
	    avl.insert(8);
	    avl.insert(9);
	    avl.insert(10);

	    System.out.println("BST height: 2 "+bst.height(3) ); 
	    System.out.println("AVL height: 1"+avl.height(2) );  
	}
    }

//Test NUMERO UNO - ACTIVIDADEs
/*
package avltree;
import exceptions.ItemDuplicated;
import exceptions.ExceptionEmpty;
import treelink.BSTree;
public class TestAvl {
    public static void main(String[] args) throws ExceptionEmpty {
        AVLTree<Integer> avlTree = new AVLTree<>();

        try {
            // Caso 1: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RSR
            avlTree.insert(30);
            System.out.println(avlTree);
            avlTree.insert(20);
            System.out.println(avlTree);
            avlTree.insert(40);
            System.out.println(avlTree);
            avlTree.insert(10);
            System.out.println(avlTree);
            avlTree.insert(25);
            System.out.println(avlTree);
            avlTree.insert(5);
            System.out.println(avlTree);

            // Caso 2: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RSL
            avlTree.insert(38);
            System.out.println(avlTree);
            avlTree.insert(45);
            System.out.println(avlTree);
            avlTree.insert(50);
            System.out.println(avlTree);

            // Caso 3: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RDR
            avlTree.insert(35);
            System.out.println(avlTree);
            avlTree.insert(31);
            System.out.println(avlTree);
            avlTree.insert(33);
            System.out.println(avlTree);

            // Caso 4: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RDL
            avlTree.insert(70);
            System.out.println(avlTree);
            avlTree.insert(65);
            System.out.println(avlTree);
            avlTree.insert(60);
            System.out.println(avlTree);
            
            // Caso 5: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RSR
            avlTree.insert(30);
            System.out.println(avlTree);
            avlTree.insert(20);
            System.out.println(avlTree);
            avlTree.insert(40);
            System.out.println(avlTree);
            avlTree.insert(10);
            System.out.println(avlTree);
            avlTree.insert(25);
            System.out.println(avlTree);
            avlTree.insert(5);
            System.out.println(avlTree);
            
            // Caso 6: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RSL
            avlTree.insert(38);
            System.out.println(avlTree);
            avlTree.insert(45);
            System.out.println(avlTree);
            avlTree.insert(50);
            System.out.println(avlTree);

            // Caso 7: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RDR
            avlTree.insert(35);
            System.out.println(avlTree);
            avlTree.insert(31);
            System.out.println(avlTree);
            avlTree.insert(33);
            System.out.println(avlTree);

            // Caso 8: Inserción de elementos que provocan un desequilibrio y se resuelve con una rotación RDL
            avlTree.insert(70);
            System.out.println(avlTree);
            avlTree.insert(65);
            System.out.println(avlTree);
            avlTree.insert(60);
            System.out.println(avlTree);
            
            
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
        String treeString = avlTree.toString();
        System.out.println("AVL Tree: " + treeString);
    }
}
*/
