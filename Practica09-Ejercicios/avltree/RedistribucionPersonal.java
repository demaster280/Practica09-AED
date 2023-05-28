
package avltree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class RedistribucionPersonal {
    public static void main(String[] args) {
        AVLTree<Integer> comercialTree = new AVLTree<>();
        AVLTree<Integer> produccionTree = new AVLTree<>();
        AVLTree<Integer> comunicacionesTree = new AVLTree<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Empresa.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int origen = Integer.parseInt(fields[1].trim());
                int destino = Integer.parseInt(fields[2].trim());

                switch (origen) {
                    case 1:
                        comercialTree.insert(destino);
                        break;
                    case 2:
                        produccionTree.insert(destino);
                        break;
                    case 3:
                        comunicacionesTree.insert(destino);
                        break;
                }
            }
            
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el número: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al insertar en el árbol AVL: " + e.getMessage());
        }
        System.out.println("Árbol AVL del departamento Comercial:");
        System.out.println(comercialTree);
        System.out.println();
        System.out.println("Árbol AVL del departamento Producción:");
        System.out.println(produccionTree);
        System.out.println();
        System.out.println("Árbol AVL del departamento Comunicaciones:");
        System.out.println(comunicacionesTree);
        System.out.println();
    }
}
