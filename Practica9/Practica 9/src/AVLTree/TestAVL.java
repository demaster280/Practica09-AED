/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AVLTree;

/**
 *
 * @author Gabriel
 */
public class TestAVL {
    public static void main(String[] args) throws ItemDuplicated {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Caso 1: Inserción de elementos en orden creciente
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.insert(80);

        // Caso 2: Inserción de elementos en orden decreciente
        avlTree.insert(100);
        avlTree.insert(90);
        avlTree.insert(110);
        avlTree.insert(70);
        avlTree.insert(60);
        avlTree.insert(40);
        avlTree.insert(30);

        // Caso 3: Inserción de elementos desordenados
        avlTree.insert(50);
        avlTree.insert(30);
        avlTree.insert(70);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(80);
        avlTree.insert(10);

        // Caso 4: Inserción de elementos en un patrón específico
        avlTree.insert(40);
        avlTree.insert(20);
        avlTree.insert(60);
        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(50);
        avlTree.insert(70);
        avlTree.insert(5);

        // Caso 5: Inserción de elementos que requieren rotaciones RSR
        avlTree.insert(45);
        avlTree.insert(35);
        avlTree.insert(55);

        // Caso 6: Inserción de elementos que requieren rotaciones RSL
        avlTree.insert(20);
        avlTree.insert(35);
        avlTree.insert(45);

        // Caso 7: Inserción de elementos que requieren rotaciones RDR
        avlTree.insert(65);
        avlTree.insert(75);

        // Caso 8: Inserción de elementos que requieren rotaciones RDL
        avlTree.insert(65);
        avlTree.insert(75);

        // Imprimir árbol AVL después de las inserciones
        avlTree.printTree();
    }
}