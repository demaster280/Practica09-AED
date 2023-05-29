


package AVLTree;
public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            super(data);
            bf = 0;
        }

        public String toString() {
            return data.toString() + " (BF: " + bf + ")";
        }
    }
    private boolean height; // indicador de cambio de altura

    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL)this.root);
    }
    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) {
                throw new ItemDuplicated(x + " ya se encuentra en el árbol.");
            } else if (resC < 0) {
                fat.right = insert(x, (NodeAVL)node.right);
                if (this.height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1: // bf = 2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL)node.left);
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
        NodeAVL hijo = (NodeAVL)node.right;
        switch(hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
            break;
            case -1:
                NodeAVL nieto = (NodeAVL)hijo.left;
                switch(nieto.bf) {
                    case -1: node.bf = 0; hijo.bf = 1; break;
                    case 0: node.bf = 0; hijo.bf = 0; break;
                    case 1: node.bf = 1; hijo.bf = 0; break;
                }
            nieto.bf =0;
            node.right = rotateSR(hijo);
            node = rotateSL(node);
        }
        return node;
    }     
    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL)node.left;
        switch(hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL)hijo.right;
                switch(nieto.bf) {
                    case 1: node.bf = 0; hijo.bf = -1; break;
                    case 0: node.bf = 0; hijo.bf = 0; break;
                    case -1: node.bf = -1; hijo.bf = 0; break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
        }
        return node;
    }     
    private NodeAVL rotateSL(NodeAVL node){
        NodeAVL p = (NodeAVL)node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }
    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL)node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }     
    public void printTree() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
        } else {
            printTree((NodeAVL) root, 0);
        }
    }
    private void printTree(NodeAVL node, int level) {
        if (node != null) {
            printTree((NodeAVL) node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(node);
            printTree((NodeAVL) node.left, level + 1);
        }
    }     
    public void delete(E x) {
        this.height = false;
        this.root = delete(x, (NodeAVL) this.root);
    }
    protected Node delete(E x, NodeAVL node) {
        if (node == null) {
            return null;
        } else {
            int resC = node.data.compareTo(x);
            if (resC < 0) {
                node.right = delete(x, (NodeAVL) node.right);
                if (this.height) {
                    node = balanceToLeft(node);
                }
            } else if (resC > 0) {
                node.left = delete(x, (NodeAVL) node.left);
                if (this.height) {
                    node = balanceToRight(node);
                }
            } else {
                if (node.left == null) {
                    this.height = true;
                    return (NodeAVL) node.right;
                } else if (node.right == null) {
                    this.height = true;
                    return (NodeAVL) node.left;
                } else {
                    NodeAVL successor = findMin((NodeAVL) node.right);
                    node.data = successor.data;
                    node.right = delete(node.data, (NodeAVL) node.right);
                    if (this.height) {
                        node = balanceToLeft(node);
                    }
                }
            }
        }
        return node;
    }
    private NodeAVL findMin(NodeAVL node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = (NodeAVL) node.left;
        }
        return node;
    }
}  
