


package treelink;
import exceptions.ItemNoFound;
import exceptions.ItemDuplicated;
import exceptions.ExceptionEmpty;
import java.util.Stack;
public class BSTree<E extends Comparable<E>>{ 
    protected class Node{
        protected E data; 
        protected Node left, right;         
        public Node (E data){
            this(data,null,null);
        } 
        public E getData() {
			return data;
		}
		public void setData(E data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node (E data, Node left, Node right){
            this.data=data; 
            this.left = left; 
            this.right = right;
        } 
    }     
    protected Node root; 
    public BSTree(){ 
        this.root = null;
    } 
    public boolean isEmpty(){ 
        return this.root == null;
    }   
    public void insert(E x) throws ItemDuplicated{
        root = insert(root, x);
    }      
    private Node insert(Node node, E x) throws ItemDuplicated {
        if (node == null) {
            return new Node(x);
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insert(node.left, x);
        } else if (compareResult > 0) {
            node.right = insert(node.right, x);
        } else {
            throw new ItemDuplicated("El elemento " + x + " ya existe en el árbol.");
        }

        return node;
    }    
    public E search(E x) throws ItemNoFound{
        return search(root, x);
    }    
    private E search(Node node, E x) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El elemento " + x + " no se encuentra en el árbol.");
        }
        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return search(node.left, x);
        } else if (compareResult > 0) {
            return search(node.right, x);
        } else {
            return node.data;
        } 
    }
    public void remove(E x) throws ItemNoFound{
         root = remove(root, x);
    } 
    private Node remove(Node node, E x) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El elemento " + x + " no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            node.left = remove(node.left, x);
        } else if (compareResult > 0) {
            node.right = remove(node.right, x);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node minRight = findMin(node.right);
                node.data = minRight.data;
                node.right = remove(node.right, minRight.data);
            }
        }
        return node;
    }     
    private Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }   
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }     
    private void toString(Node node, StringBuilder sb) {
        if (node != null) {
            toString(node.left, sb);
            sb.append(node.data).append(" ");
            toString(node.right, sb);
        }
    }
    public E minRemove() throws ExceptionEmpty{
    	Node aux = minRemove(this.root);
    	return aux.data;
    }
    
    private Node minRemove(Node current) throws ExceptionEmpty{
    	if (isEmpty())
    		throw new ExceptionEmpty ("BST is empty ....");
    	
    	if (current.left != null)
    		return minRemove(current.left);
    	return current;
    }
    
    public void inOrdeb(){
        inOrder(root);
    } 
    protected void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    //Ejercicio 1
    public int countNodes() {
        return countNodes(root);
    }
    
    private int countNodes(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    public int height(E x) {
        Node node = findNode(root, x);
        if (node == null) {
            return -1; // El nodo no existe en el árbol
        }
        return height(node);
    }

    private Node findNode(Node node, E x) {
        if (node == null || x.equals(node.data)) {
            return node;
        }
        int compareResult = x.compareTo(node.data);
        if (compareResult < 0) {
            return findNode(node.left, x);
        } else {
            return findNode(node.right, x);
        }
    }
    
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //Ejercicio 2
    public int calculateArea() {
        int leafCount = countLeaves(root);
        int height = calculateHeight(root);
        return leafCount * height;
    }
    
    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }
    
    private int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //Ejercicio 3
    public void iterativePreOrder() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.data + " ");
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            current = current.right;
        }
        System.out.println();
    }
    
	//Ejercicio 4
	public void parenthesize() {
        parenthesize(root, 0);
    }
	
    private void parenthesize(Node node, int level) {
        if (node != null) {
            StringBuilder sb = new StringBuilder();
            // Agregar la sangría correspondiente al nivel actual
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            // Imprimir el valor del nodo entre paréntesis
            sb.append("(").append(node.data).append(")");
            // Imprimir el contenido del nodo
            System.out.println(sb.toString());
            // Recursivamente imprimir los subárboles izquierdo y derecho
            parenthesize(node.left, level + 1);
            parenthesize(node.right, level + 1);
        }
    }

	@SuppressWarnings("unused")
	private String getIndentation(int level) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < level; i++) {
	        sb.append("  ");
	    }
	    return sb.toString();
	}
}