



package avltree;
import treelink.BSTree;
import exceptions.ExceptionEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
import treelink.LinkBST;
public class AVLTree<E extends Comparable<E>> extends BSTree<E>  {
    	class NodeAVL extends Node {
		protected int bf;
		public NodeAVL(E data) {
			super(data);
			this.bf = 0;
		}
		public String toString() {
			 return data.toString() + " (BF: " + bf + ")";
		}
	}	
	private boolean height; //indicador de cambio de altura

	public AVLTree() {
		super();
	}	
	public void insert(E x) throws ItemDuplicated {
		this.height = false;
		this.root = insert(x, (NodeAVL)this.root);
	}	
	protected Node insert(E x, NodeAVL node)throws ItemDuplicated{
		NodeAVL fat = node;
		if (node == null) {
			this.height = true;
			fat = new NodeAVL (x); 
		}
		else {
			int resC = node.getData().compareTo(x);
			if(resC == 0)
				throw new ItemDuplicated(x+" ya se encuentra en el arbol...");
			if(resC < 0) {
				fat.setRight(insert(x, (NodeAVL)node.getRight()));
				if(this.height)
					switch(fat.bf) {
					case -1: fat.bf = 0;
						this.height = false;
						break;
					case 0: fat.bf = 1;
						this.height = true;
						break;
					case 1: //bf = 2
						fat = balanceToLeft(fat);
						this.height = false;
						break;
					}
			}
			else {
				fat.setLeft(insert(x, (NodeAVL)node.getLeft()));
				if (this.height) {
					switch (fat.bf) {
						case 1:
							fat.bf = 0;
							this.height = false;
							break;
						case 0:
							fat.bf = -1;
							this.height = true;
							break;
						case -1: // bf = -2
							fat = balanceToRight(fat);
							this.height = false;
							break;
					}
				}
			}
		}
		return fat;
	}

	private NodeAVL balanceToLeft(NodeAVL node){
		NodeAVL hijo = (NodeAVL)node.getRight();
		switch(hijo.bf) {
		case 1:
			node.bf = 0;
			hijo.bf = 0;
			node = rotateSL(node);
			break;
		case -1:
			NodeAVL nieto = (NodeAVL)hijo.getLeft();
			switch(nieto.bf) {
			case -1: node.bf = 0; hijo.bf = 1; break;
			case 0: node.bf = 0; hijo.bf = 0; break;
			case 1: node.bf = 1; hijo.bf = 0; break;
			}
			nieto.bf =0;
			node.setRight(rotateSR(hijo));
			node = rotateSL(node);
		}
		return node;
	}
	
	private NodeAVL balanceToRight(NodeAVL node) {
		NodeAVL hijo = (NodeAVL)node.getLeft();
		switch(hijo.bf) {
			case -1:
				node.bf = 0;
				hijo.bf = 0;
				node = rotateSR(node);
				break;
			case 1:
				NodeAVL nieto = (NodeAVL)hijo.getRight();
				switch(nieto.bf) {
					case 1: node.bf = 0; hijo.bf = -1; break;
					case 0: node.bf = 0; hijo.bf = 0; break;
					case -1: node.bf = -1; hijo.bf = 0; break;
				}
				nieto.bf = 0;
				node.setLeft(rotateSL(hijo));
				node = rotateSR(node);
		}
		return node;
	}
	
	private NodeAVL rotateSL(NodeAVL node){
		NodeAVL p = (NodeAVL)node.getRight();
		node.setRight(p.getLeft());
		p.setLeft(node);
		node = p;
		return node;
	}
	
	private NodeAVL rotateSR(NodeAVL node) {
	        NodeAVL p = (NodeAVL)node.getLeft();
	        node.setLeft(p.getRight());
	        p.setRight(node);
	        node = p;
	        return node;
	}
	public E getDataRoot() throws ExceptionEmpty {
		if (isEmpty())
			throw new ExceptionEmpty( "Arbol esta vacio...");
		return this.root.getData();
	}
        /*
        //Ejercicio 2
	// Redefinición del método de eliminación de elementos
        public void remove(T item) throws ItemNoFound {
            root = remove(root, item);
        }
        // Método privado para eliminar un elemento del árbol
        private Node<T> remove(Node<T> node, T item) throws ItemNoFound {
            if (node == null) {
                throw new ItemNoFound();
            }
            int compareResult = item.compareTo(node.data);
            if (compareResult < 0) {
                node.left = remove(node.left, item);
            } else if (compareResult > 0) {
                node.right = remove(node.right, item);
            } else {
                if (node.left != null && node.right != null) {
                    // El nodo a eliminar tiene dos hijos
                    Node<T> successor = findMin(node.right);
                    node.data = successor.data;
                    node.right = remove(node.right, successor.data);
                } else {
                    // El nodo a eliminar tiene uno o ningún hijo
                    node = (node.left != null) ? node.left : node.right;
                }
            }
            // Verificar y realizar ajustes de balance
            if (node != null) {
                int balance = getHeight(node.left) - getHeight(node.right);
            if (balance > 1) {
                // Rotación derecha
                if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                    node = rotateRight(node);
                } else {
                    // Rotación izquierda-derecha
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            } else if (balance < -1) {
                // Rotación izquierda
                if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                    node = rotateLeft(node);
                } else {
                    // Rotación derecha-izquierda
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        }
        return node;
    }
    // Métodos de soporte
    // Obtener la altura de un nodo (altura del subárbol)
    private int getHeight(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    */
}
