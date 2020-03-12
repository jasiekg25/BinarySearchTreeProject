import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BSTTest {
    private BST binaryTree;
    private Random random = new Random();


    @Before
    public void prepare(){
        this.binaryTree = new BST();
    }

    @Test
    public void insertTest(){
        int value = this.random.nextInt();
        binaryTree.insert(value);
        assertEquals(value, binaryTree.root.value);

    }

    @Test
    public void findNthElementTest1(){
        int[] array = {1, 2, 3, 5, 6, 7};

        for (int i = 0; i < 6; i++) {
            binaryTree.insert(array[i]);
            assertEquals(array[i], binaryTree.findNthElement(i + 1));
        }
    }

    @Test
    public void insertArray(){
        int[] array = {2, 5, 1, 12, 7, 6};
        binaryTree.insertArray(array);
        assertEquals(2, binaryTree.findNthElement(2));
        assertEquals(7, binaryTree.findNthElement(5));
    }

    @Test
    public void sumTreeElementsTest(){
        int length = random.nextInt() % 1000000;
        int totalSum = 0;
        for (int i = 0; i < length; i++){
            int value = random.nextInt() % 1000;
            totalSum += value;
            binaryTree.insert(value);
        }
        assertEquals(totalSum, binaryTree.sumTreeElements());
    }

    @Test
    public void countTreeElementsTest(){
        int length = Math.abs(random.nextInt()) % 1000000;
        for (int i = 0; i < length; i++){
            int value = random.nextInt();
            binaryTree.insert(value);
        }
        assertEquals(length, binaryTree.countTreeElements());
    }

    @Test
    public void arithmeticMeanTest(){
        int[] array = {2, 5, 8, 62, 12, 8, 3, 41};
        binaryTree.insertArray(array);
        assertEquals(17, binaryTree.arithmeticMean());
    }

    @Test
    public void findMedianValueTest(){
        int length = Math.abs(random.nextInt()) % 1000000;
        for (int i = 0; i < length; i++){
            int value = random.nextInt();
            binaryTree.insert(value);
        }
        assertEquals(binaryTree.findNthElement((length / 2) + 1), binaryTree.findMedianValue());
    }
}

