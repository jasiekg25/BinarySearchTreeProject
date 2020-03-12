
public class Main {
    BST tree;

    public static void main(String[] args){
        int[] array = {2, 5, 1, 12, 7, 6};

        BST binaryTree = new BST();
        binaryTree.insertArray(array);
        binaryTree.printTree();
        System.out.println("\n");
        System.out.println("\n Sum of elements: " +  binaryTree.sumTreeElements());
        System.out.println("\n Number of elements: " + binaryTree.countTreeElements());
        System.out.println("\n Arithmetic mean: " + binaryTree.arithmeticMean());
        System.out.println("\n N-th element in Tree is: " + binaryTree.findNthElement(4) );
        System.out.println("\n Median value is: " + binaryTree.findMedianValue());



    }
}
