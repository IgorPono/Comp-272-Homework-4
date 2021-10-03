public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(E val) {
        super(val);
    }

    // returns true if BST has val else false.
    public boolean contains(E val) {
        Node current = root;
        while (current != null) {
            if (val.equals(current.getInfo()))
                return true;
            else if (val.compareTo((E) current.getInfo()) < 0)
                current = current.left;
            else
                current = current.right;

        }
        return false;
    }


    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again

    public void insert(E val) { //iterative method
        if (!contains(val)) {
            if (root == null) {
                root = new Node(val);
                size++;
                return;
            }
            Node current = root;
            while (true) {
                if (val.compareTo((E)current.getInfo())<0){
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.addLeft(new Node(val));
                        size++;
                        break;
                    }
                }
                else{
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.addRight(new Node(val));
                        size++;
                        break;
                    }
                }
            }

        }
    }

    public void insert1(E val){ //recursive method
        if(root==null){
            root = new Node(val);
            size++;
            return;
        }
        if(!contains(val)){
            insertHelper(root,val);
        }
    }

    private void insertHelper(Node n,E val){
        if(val.compareTo((E)n.getInfo())<0){
            if(n.left!=null){
                insertHelper(n.left,val);
            } else {
                n.addLeft(new Node(val));
                size++;
            }
        }
        else{
            if(n.right!=null){
                insertHelper(n.right,val);
            } else{
                n.addRight(new Node(val));
                size++;
            }
        }
    }


    // returns the minimum value stored in the tree
    public E findMin() {
        Node current = root;
        if(current==null)
            return null;
        while (current.left != null) {
            current = current.left;
        }
        if (current != null)
            return (E) current.getInfo();
        else
            return null;
    }


    // returns the maximum value stored in the tree
    public E findMax() {
        Node current = root;
        if (current == null)
            return null;
        while (current.right != null) {
            current = current.right;
        }
        if (current != null)
            return (E) current.getInfo();
        else
            return null;
    }

   /* public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>(50);
        //bt.insert(5);
        //bt.insert(10);
        //bt.insert(3);
        //bt.insert(20);
        //bt.insert(8);
        //bt.insert(4);
        //System.out.println(bt.findMax());
        //bt.inOrder(bt.root);
        bt.addLeft(bt.root, 25);
        bt.addRight(bt.root, 100);
        //bt.inOrder(bt.root);
        //bt.insert(5);
        //bt.insert(10);
        //bt.insert(3);
        //bt.insert(20);
        //bt.insert(8);
        bt.insert1(4);
        System.out.println(bt.contains(4));
        bt.inOrder(bt.root);
        System.out.println(bt.findMax());
        System.out.println(bt.findMin());

    } */

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert1(5);
        bt.insert1(10);
        bt.insert(10);
        bt.insert(3);
        //bt.insert1(3);
        //bt.insert1(20);
        //bt.insert1(8);
        //bt.insert1(4);
        //bt.insert(1);
        //bt.insert(2);
        //bt.insert(3);

        bt.inOrder(bt.root);
        System.out.println();
        bt.preOrder(bt.root);
        System.out.println();
        bt.postOrder(bt.root);
        System.out.println(bt.contains(5));
        System.out.println(bt.findMin());
        System.out.println(bt.findMax());
        System.out.println(bt.size);
    }
}


