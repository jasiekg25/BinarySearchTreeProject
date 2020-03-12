
public class BST {
    Node root;

    public BST() {
        this.root = null;
    }



    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }



    //    Sum elements of tree
    public int sumTreeElements() {
        if (this.root == null) {
            System.out.println("Empty Tree in countElements (root is NULL)");
            return 0;
        }
        return sumElements(this.root);
    }

    public static int sumElements(Node root) { // just inOrder + accumulation; sumElements(root, 0)
        if (root != null) {
            return (sumElements(root.left) + root.value + sumElements(root.right));
        }
        return 0;
    }



    //    Print
    public void printTree() {
        if (this.root == null) {
            System.out.println("Tree is empty in printTree (root is NULL)");
            return;
        }
        printTree(this.root);

    }

    private void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.value);
            printTree(root.right);
        }
    }



    //    Count elements of tree
    public int countTreeElements() {
        if (this.root == null) {
            System.out.println("Empty Tree in countElements (root is NULL)");
            return 0;
        }
        return countElements(this.root);
    }

    public static int countElements(Node root) { // countElements(root,0,0)
        if (root != null) {
            return (1 + countElements(root.left) + countElements(root.right));
        }
        return 0;
    }



    //    Insert
    public void insertArray(int[] values) {
        int index = 0;
        if (this.root == null) {
            this.root = new Node(values[index]);
            index++;
        }
        for (; index < values.length; index++) {
            insert(this.root, values[index]);
        }
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value <= root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }



    //    Arithmetic mean
    public int arithmeticMean() {
        if (this.root == null) {
            System.out.println("Empty Tree in arithmeticMean (root is NULL)");
            return 0;
        }
        return arithmeticMean(this.root);
    }

    public int arithmeticMean(Node root) {
        int sum = sumElements(root);
        int counter = countElements(root);

        if (counter == 0) {
            System.out.println("Empty Tree in arithmeticMean (root is NULL)");
            return 0;
        }
        return (sum / counter); // depends what you want float/ceil/floor
    }



    //  Find n-th element in tree (counting inorder)
    public int findNthElement(int n) {
        if (this.root == null) {
            System.out.println("Empty Tree in findNthElement (root is NULL)");
            return 0;
        }
        return findNthElement(this.root, n);

    }

    public static int findNthElement(Node root, int n) {
        if (root != null) {
            int leftSize = countElements(root.left);
            if (n - leftSize == 1)
                return root.value;
            else if (n - leftSize < 1)
                return findNthElement(root.left, n);
            else if (n - leftSize > 1)
                return findNthElement(root.right, n -1 - leftSize);

        }
        return root.value;
    }



    //        find median
    public int findMedianValue(){
        if (this.root == null) {
            System.out.println("Empty Tree in findMedianValue (root is NULL)");
            return 0;
        }
        return findMedianValue(this.root);
    }

    public int findMedianValue(Node root) {

        int totalCounter = countElements(root);
        if (totalCounter % 2 == 1) {
            return findNthElement(root, (totalCounter / 2) +1);
        } else {                       // different expectations, sometimes smaller/greater, arithmeticMean or both, I will return greater
            return findNthElement(root, (totalCounter / 2) + 1);
        }
    }
}


